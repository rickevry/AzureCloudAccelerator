public class main {
    public static void main(String[] args) {

        String tenantDomainName = args[0];
        String principalId = args[1];
        String secretKey = args[2];
        String userName = args[3];

		AppParameter.setTenantDomainName(tenantDomainName);
		AppParameter.setTenantContextId(tenantDomainName);
		AppParameter.setAppPrincipalId(principalId);
		AppParameter.setSymmetricKey(secretKey);

		AppParameter.setEvoStsUrl("https://login.windows.net/%s/oauth2/token?api-version=1.0");
		AppParameter.setProtectedResourceHostName("graph.windows.net");
		AppParameter.setRestServiceHost("graph.windows.net");
    	AppParameter.setAcsPrincipalId("00000001-0000-0000-c000-000000000000");
		AppParameter.setEvoStsUrl("https://login.windows.net/%s/oauth2/token?api-version=1.0");


        System.out.println("handleRequest start");
        try {
            HttpRequestHandler.init();

            // System.out.println("------- list all users top 100 -----------------------------------------------------------------------------------------------");
            // String result = HttpRequestHandler.handleRequest("/users", "$top=100");

            System.out.println("------- get user info -----------------------------------------------------------------------------------------------");
            String userInfo = HttpRequestHandler.handleRequest("/users/" + userName,"");
            System.out.println(userInfo);
            
            System.out.println("------- get user groups ---------------------------------------------------------------------------------------------");
            String groups = HttpRequestHandler.handleRequest("/users/" + userName + "/$links/memberOf", "$top=100");
            System.out.println(groups);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("handleRequest end");
    }
}

// graph api
// https://msdn.microsoft.com/en-us/library/azure/ad/graph/api/users-operations


