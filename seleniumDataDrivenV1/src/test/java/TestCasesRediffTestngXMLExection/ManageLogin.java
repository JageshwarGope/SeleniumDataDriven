package TestCasesRediffTestngXMLExection;

import baseClass.BaseTestClass;

public class ManageLogin extends BaseTestClass {

	public void login() {
		System.out.println("login method");
		app.openBrowser("browser_name");
	}
	
	public void logout() {
		System.out.println("logout method");
	}
	
}
