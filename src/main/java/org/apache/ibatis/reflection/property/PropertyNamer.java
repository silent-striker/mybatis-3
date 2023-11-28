/*
 *    Copyright 2009-2023 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.reflection.property;

import java.util.Locale;

import org.apache.ibatis.reflection.ReflectionException;

/**
 * @author Clinton Begin
 */
public final class PropertyNamer {

  private PropertyNamer() {
    // Prevent Instantiation of Static Class
  }

  public static String methodToProperty(String name) {
    int startIndex;
    if (name.startsWith("is")) {
      startIndex = 2;
      name = name.substring(startIndex);
    } else if (name.startsWith("get") || name.startsWith("set")) {
      startIndex = 3;
      name = name.substring(startIndex);
    } else {
      throw new ReflectionException(
        "Error parsing property name '" + name + "'.  Didn't start with 'is', 'get' or 'set'.");
    }

    int secondCharIndex = 1;
    int minimumLength = 1;
    if (name.length() == minimumLength || name.length() > minimumLength && !Character.isUpperCase(name.charAt(secondCharIndex))) {
      startIndex = 0;
      int endIndex = 1;
      int startAfterEndIndex = endIndex;

      name = name.substring(startIndex, endIndex).toLowerCase(Locale.ENGLISH) + name.substring(startAfterEndIndex);
    }

    return name;
  }

  public static boolean isProperty(String name) {
    return isGetter(name) || isSetter(name);
  }

  public static boolean isGetter(String name) {
    return name.startsWith("get") && name.length() > 3 || name.startsWith("is") && name.length() > 2;
  }

  public static boolean isSetter(String name) {
    return name.startsWith("set") && name.length() > 3;
  }

}
