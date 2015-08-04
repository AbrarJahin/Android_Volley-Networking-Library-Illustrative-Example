package volley;

//This class is for storing all URLs as a model of URLs

public class Config_URL
{
	private static final String URL_JSON_OBJECT = "http://api.appnucleus.com/volley/person_object.JSON";
	private static final String URL_JSON_ARRAY  = "http://api.appnucleus.com/volley/person_array.JSON";
	private static final String URL_STRING_REQ  = "http://api.appnucleus.com/volley/string_response.html";
	private static final String URL_IMAGE       = "http://api.appnucleus.com/volley/volley-image.jpg";

	//If you need any parameter passed with the URL (GET) - U need to modify this functions
	public static String get_JSON_Object_URL()
	{
		return URL_JSON_OBJECT;
	}

	public static String get_JSON_Array_URL()
	{
		return URL_JSON_ARRAY;
	}

	public static String get_String_URL(String Input)
	{
		if(Input.length()>0) {
			return Input;
		}
		return URL_STRING_REQ;
	}

	public static String get_Image_URL()
	{
		return URL_IMAGE;
	}
}
