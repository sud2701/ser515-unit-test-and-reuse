/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sudheer Reddy Kunduru
 * @version 2.0
 * 
 *          Update to Java 8
 */

public class Hacs {

	static Facade theFacade = new Facade();

	public Hacs() {
	}

	public static void main(String[] args) throws Exception {

		UserInfoItem userInfoItem = new UserInfoItem();
		theFacade.createCourseList();
		while (true) {
			boolean bExit;
			bExit = Facade.login(userInfoItem);
			if (bExit) {
				break;
			}
			theFacade.createUser(userInfoItem);
			theFacade.attachCourseToUser();
			if (userInfoItem.userType == 0) {
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