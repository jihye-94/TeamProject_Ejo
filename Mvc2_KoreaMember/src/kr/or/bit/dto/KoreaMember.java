package kr.or.bit.dto;

public class KoreaMember {
	 	private String id;
	    private String pwd;
	    private String name;
	    private int age;//주의
	    private String gender;
	    private String email;
	    private String ip;
	    

	    
	    public String getId(){
	        return id;
	    }
	    
	    public void setId(String id){
	        this.id = id;
	    }
	    
	    public String getPwd(){
	        return pwd;
	    }
	    
	    public void setPwd(String pwd){
	        this.pwd = pwd;
	    }
	    
	    public String getName(){
	        return name;
	    }
	    
	    public void setName(String name){
	        this.name = name;
	    }
	    
	    public int getAge(){
	        return age;
	    }
	    
	    public void setAge(int age){
	        this.age = age;
	    }
	    
	    public String getGender(){
	        return gender;
	    }
	    
	    public void setGender(String gender){
	        this.gender = gender;
	    }
	    
	    public String getEmail(){
	        return email;
	    }
	    
	    public void setEmail(String email){
	        this.email = email;
	    }
	    
	    public String getIp(){
	        return ip;
	    }
	    
	    public void setIp(String ip){
	        this.ip = ip;
	    }
	    @Override
	    public String toString(){
	        return "memberDto{" +
	                "id='" + id + '\'' +
	                ", pwd='" + pwd + '\'' +
	                ", name='" + name + '\'' +
	                ", age=" + age +
	                ", gender='" + gender + '\'' +
	                ", email='" + email + '\'' +
	                ", ip='" + ip + '\'' +
	                '}';
	    }
	
}
