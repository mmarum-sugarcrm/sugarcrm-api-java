package com.sugarcrm.api.v4.impl;

import com.sugarcrm.api.SugarSession;

public class SugarLoginResponse implements SugarSession{
		protected String id;
		//Should be 'Users'
		protected String module_name;
		protected UsersResponse name_value_list;
		public String getSessionID() {
			return id;
		}
		public String getUserName(){
			return name_value_list.user_name.value;
		}
		public String getUserId(){
			return name_value_list.user_id.value;
		}
}
