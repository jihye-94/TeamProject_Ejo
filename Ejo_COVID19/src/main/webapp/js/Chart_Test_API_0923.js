$(function() {
	src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"
	let API = "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=92ibMhGHcauJEjEw8dROXtXF62wLnfcUL9UDomkw19XjcxxtY9FdEjxxP5lbadu68y6wEJNe8MSVF7NGnCqN2w%3D%3D";
	let data = API.data;

	$.getJSON(API, data, function(data, textStatus, xhr) {
		console.log(data);
		console.log(data.data);

		let mainCity = document.getElementById("main-city"); //html select main-city를 담음
		let subCity = document.getElementById("sub-city"); //html select sub-city를 담음
		let covi = data.data; //API 전체 데이터를 담을 배열 
		let mainCityArr = []; //API의 전체 sido를 담을 배열 
		let subCityArr = []; //API의 전체 sigungn의 담을 배열 
		let splitSigungu = []; //API의 전체 sigungn의 첫단어만 담을 배열

		console.log(covi);

		createArr();
		cutArr();
		sortArrAddOption(mainCityArr, mainCity);

		//sido의 값을 일괄 담는 mainCityArr배열 생성 
		function createArr() {
			for (let i in covi) {
				mainCityArr.push(covi[i].sido);
			}
		}

		//시군구를 split-> 앞단어 1개만 담는 sigungu배열 생성 (천안시 동구-> 천안시, 용인시 처인구->용인시)
		function cutArr() {
			for (let i in covi) {
				let splitArr = covi[i].sigungu.split(" ", 1);
				splitSigungu.push(splitArr[0]);
			}
		}

		//시티 배열을 정렬, 중복제거, 셀렉 옵션 생성, 옵션의 innertxt에 .
		function sortArrAddOption(CityArr, City) {
			let sortArrTmp = [];
			CityArr.forEach((element) => {
				if (!sortArrTmp.includes(element)) {
					sortArrTmp.push(element);
				}
				uniqueArr = sortArrTmp.sort();
			})
			for (let index in uniqueArr) {
				let oele = document.createElement("option");
				let txt = document.createTextNode(uniqueArr[index]);
				oele.appendChild(txt);
				City.appendChild(oele);
			}
		}
		
		//시구(mainCity) 셀렉트에 맞는 시군구(subCity) 옵션 출력(add->remove반복)
		mainCity.addEventListener("change", function() {
			subCityArr = [];
			subCity.innerHTML = '';
			mainOption = mainCity.options[mainCity.selectedIndex].innerText;
			for (let i in covi) {
				if (mainOption == covi[i].sido) {
					subCityArr.push(splitSigungu[i]);
				}
			}
			sortArrAddOption(subCityArr, subCity);
		})

		console.log('-----------------------테이블-----------------------');

		let selectedSido = ""; //선택한 sido
		let selectedSigungu = "";

		console.log("selectedSido");

		//클릭하여 변경된 시도의 값을 셀렉 
		mainCity.addEventListener("change", function(event) {
			console.log(event.currentTarget.value);
			selectedSido = event.currentTarget.value; //시도
			if (selectedSido == "시도") {
				showTenContent()
			}
		});

		//테이블에 정보를 넣는 함수 
		//구군에 변경이 있을 경우 시도, 시군구 일치여부 확인하여 일치시 covi 배열에서 4가지 요소값 꺼내 테이블에 담음 
		subCity.addEventListener("change", function() {
			let tbody = document.getElementById("tbody");
			tbody.innerHTML = "";
			selectedSigungu = event.currentTarget.value;
			for (let i = 0; i < covi.length; i++) {
				if (selectedSido == covi[i].sido && selectedSigungu == splitSigungu[i]) {
					tbody.innerHTML += "<tr>" +
						"<td>" + covi[i].facilityName + "</td>\n" +
						"<td>" + covi[i].centerName + "</td>\n" +
						"<td>" + covi[i].address + "</td>\n" +
						"<td>" + covi[i].phoneNumber + "</td>\n" + "</tr>";
				}
			}
		});

		//API의 정보 10개만 테이블 생성 함수 초기 화면 기본 세팅 
		$(function() {
			for (i = 0; i < 10; i++) {
				tbody.innerHTML += "<tr>" +
					"<td>" + covi[i].facilityName + "</td>\n" +
					"<td>" + covi[i].centerName + "</td>\n" +
					"<td>" + covi[i].address + "</td>\n" +
					"<td>" + covi[i].phoneNumber + "</td>\n" + "</tr>";
			}
			console.log("ajdajd");
		});

console.log("-------------------------차트------------------------------");

		$(function() {
			let sortArrTmp = [];
			let sortArrSido = [];
			let CountSido = [];
			//정렬
			mainCityArr.forEach((element) => {
				if (!sortArrTmp.includes(element)) {
					sortArrTmp.push(element);
				}
			})
			//중복제거
			sortArrSido = sortArrTmp.sort();
			//sido의 개수를 sortArrSido 순서대로 CountSido배열에 담음 
			for (let i in sortArrSido) {
				CountSido.push(mainCityArr.sort().filter(element => sortArrSido[i] === element).length);
			}

			console.log(CountSido);

			const chart = Highcharts.chart('container', {
				title: {
					text: '시도별 코로나 예방접종센터 보유현황 '
				},
				xAxis: {
					categories: sortArrSido
				},
				yAxis: {
					max: 60,
					title: {
						text : "센터수"
					}
				},
				series: [{
					name: '개수',
					type: 'column',
					colorByPoint: true,
					data: CountSido,
					showInLegend: false
				}]
			});

			document.getElementById('plain').addEventListener('click', () => {
				chart.update({
					chart: {
						inverted: false,
						polar: false
					},
				});
			});

			document.getElementById('inverted').addEventListener('click', () => {
				chart.update({
					chart: {
						inverted: true,
						polar: false
					},
				});
			});

			document.getElementById('polar').addEventListener('click', () => {
				chart.update({
					chart: {
						inverted: false,
						polar: true
					},
				});
			});
		});
	});
});