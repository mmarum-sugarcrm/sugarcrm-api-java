package com.sugarcrm.api;

import java.util.Collection;

/**
 * Generic Bean API (mostly for accessing custom fields not defined within an existing API)
 * 
 * @author mmarum
 *
 */

public interface SugarBean {
  String get(String fieldName);
  Collection<String> getFieldNames();
  String getModuleName();
}
