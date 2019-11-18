package com.ge.exercise1;

import java.util.ArrayList;
import java.util.List;

public class MyParser implements Parser{
	static int index = 0;
	static List<Group> groupList = new ArrayList<>();
	static List<User> userList = new ArrayList<>();
	@Override
	public Application parseApplicationData(String data) {		

		
		String[] simpleTestData = data.split(""); //"Application(id: 0,name: MyApp,users:[User(id: 2,name: Beth Jones)],groups:[Group(id: 1,name: SimpleGroup,users:[User(id: 2,name: Beth Jones)]),Group(id: 3,name: SimpleGroup,users:[User(id: 3,name: Beth Jones)])])"
				//.split("");
		MyApplication app = null;
		
		
		List<String> spSymbol = new ArrayList<>();
		spSymbol.add(")");
		spSymbol.add("(");
		spSymbol.add("[");
		spSymbol.add(",");
		spSymbol.add(":");
		// spSymbol.add(" ");
		// Validate Application
		if ("Application".equals(getTag(simpleTestData, spSymbol))) {
			if ("(".equals(simpleTestData[index++])) {
				app = new MyApplication(getId(simpleTestData, spSymbol), getName(simpleTestData, spSymbol));
				for (index++; index < simpleTestData.length;) {
					String tag = getTag(simpleTestData, spSymbol);
					if ("users".equals(tag) && ":".equals(simpleTestData[index++])
							&& "[".equals(simpleTestData[index++])) {
						boolean isNext = true;
						do {

							getUserDetails(simpleTestData, spSymbol);
							if (!",".equals(simpleTestData[index++])) {
								isNext = false;
							}
						} while (isNext);
						if ("]".equals(simpleTestData[index])) {

						}

					}

					if ("groups".equals(tag) && ":".equals(simpleTestData[index++])
							&& "[".equals(simpleTestData[index++])) {
						boolean isNext = true;
						do {
							getGroupDetails(simpleTestData, spSymbol);
							if (!",".equals(simpleTestData[index++])) {
								isNext = false;
							}
						} while (isNext);
						if ("]".equals(simpleTestData[index])) {

						}
					}

					if (!",".equals(simpleTestData[index++])) {
						index = simpleTestData.length + 1;
					}

				}

			}

		}
		app.group = groupList;
		app.user = userList;	
		return app;
	}
	
	private static void getGroupDetails(String[] simpleTestData, List<String> spSymbol) {
		boolean isNext = true;

		if ("Group".equals(getTag(simpleTestData, spSymbol)) && "(".equals(simpleTestData[index++])) {
			groupList.add(new MyGroup(getId(simpleTestData, spSymbol),getName(simpleTestData, spSymbol)));
			
			//getId(simpleTestData, spSymbol);
			//getName(simpleTestData, spSymbol);
	
			index++;

			if ("users".equals(getTag(simpleTestData, spSymbol)) && ":".equals(simpleTestData[index++])
					&& "[".equals(simpleTestData[index++])) {

				do {
					getUserDetails(simpleTestData, spSymbol);

					if (!",".equals(simpleTestData[index++])) {
						isNext = false;
					}

				} while (isNext);

				if ("]".equals(simpleTestData[index])) {

				}

			}

			if (!")".equals(simpleTestData[index++]) && "]".equals(simpleTestData[index++])) {
				index = simpleTestData.length + 1;
			}

		}

	}

	private static void getUserDetails(String[] simpleTestData, List<String> spSymbol) {
		if ("User".equals(getTag(simpleTestData, spSymbol)) && "(".equals(simpleTestData[index++])) {
			userList.add(new MyUser(getId(simpleTestData, spSymbol),getName(simpleTestData, spSymbol)));
			
			//getId(simpleTestData, spSymbol);
			//getName(simpleTestData, spSymbol);

		}

		if (!")".equals(simpleTestData[index++])) {
			index = simpleTestData.length + 1;
		}

	}

	private static String getId(String[] simpleTestData, List<String> spSymbol) {
		String ret = "";
		if ("id".equals(getTag(simpleTestData, spSymbol)) && ":".equals(simpleTestData[index++])
				&& " ".equals(simpleTestData[index++])) {
			ret = getTag(simpleTestData, spSymbol);

		}
		return ret;

	}

	private static String getName(String[] simpleTestData, List<String> spSymbol) {
		String ret = "";
		if (",".equals(simpleTestData[index++]) && "name".equals(getTag(simpleTestData, spSymbol))
				&& ":".equals(simpleTestData[index++]) && " ".equals(simpleTestData[index++])) {
			ret = getTag(simpleTestData, spSymbol);
		}
		return ret;
	}

	private static String getTag(String[] simpleTestData, List<String> spSymbol) {
		StringBuffer sb = new StringBuffer();

		for (; index < simpleTestData.length; index++) {
			if (!spSymbol.contains(simpleTestData[index])) {
				sb.append(simpleTestData[index]);
			} else {
				break;
			}

		}		
		return sb.toString();
	}

	
	
}
