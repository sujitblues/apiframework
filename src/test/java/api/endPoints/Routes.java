package api.endPoints;

public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User module
		public static String createUser_url=base_url+"/user";
		public static String getUser_url=base_url+"/user/{username}";
		public static String updateUser_url=base_url+"/user/{username}";
		public static String deleteUser_url=base_url+"/user/{username}";
}
