/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * 
 *          Update to Java 8
 */

public class Hacs {

	static Facade theFacade = new Facade();

	public Hacs() {
	}

	public static void main(String[] args) throws Exception {

		UserInfoItem userinfoitem = new UserInfoItem();
		theFacade.createCourseList();
		while (true) {
			boolean bExit;
			bExit = Facade.Login(userinfoitem);
			if (bExit) {
				break;
			}
			theFacade.createUser(userinfoitem);
			theFacade.attachCourseToUser();
			if (userinfoitem.userType == 0) {
				theFacade.remind();
			}
			boolean bLogout = false;
			while (!bLogout) {
				bLogout = theFacade.selectCourse();
				if (bLogout)
					break;
				bLogout = theFacade.courseOperation();
			}
		}
	}
}