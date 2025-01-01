package creational;

/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/

public class BuilderPattern
{
    public static void main(String[] args) {


      //  creational.HttpClient a = creational.HttpClient("munnibadnam","10","0811");
        HttpClient client = new HttpClient.Builder()
                .baseUrl("https://api.example.com")
                .timeOut("5000")
                .authToken("Bearer abc123")
                .build();
        System.out.println(client);
    }
}

 class HttpClient {

    String baseUrl;
    String timeOut;
    String authToken;

    HttpClient(Builder builder){
        this.baseUrl=builder.baseUrl;
        this.timeOut=builder.timeOut;
        this.authToken=builder.authToken;

    }

     @Override
     public String toString() {
         return "creational.HttpClient{" +
                 "baseUrl='" + baseUrl + '\'' +
                 ", timeout=" + timeOut +
                 ", authToken='" + authToken + '\'' +
                 '}';
     }



 static class Builder {

     String baseUrl;
     String timeOut;
     String authToken;

     public Builder baseUrl(String baseUrl) {
         this.baseUrl = baseUrl;
         return this;
     }


     public Builder timeOut(String timeOut) {
         this.timeOut = timeOut;
         return this;
     }


     public Builder authToken(String authToken) {
         this.authToken = authToken;
         return this;
     }


     public HttpClient build() {
         return new HttpClient(this);
     }
 }

}