/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.cursor;

import java.io.Closeable;

/**
 * Cursor（游标接口）
 * Cursor contract to handle fetching items lazily using an Iterator.
 * 游标契约，使用迭代器惰性地处理获取项。
 * Cursors are a perfect fit to handle millions of items queries that would not normally fits in memory.
 * 游标非常适合处理数百万项查询，而这些查询通常不适合存储在内存中。
 * If you use collections in resultMaps then cursor SQL queries must be ordered (resultOrdered="true")
 * 如果在resultmap中使用集合，则必须对游标SQL查询进行排序(resultorder ="true")
 * using the id columns of the resultMap.
 * 使用resultMap的id列。
 *
 * @author Guillaume Darmont / guillaume@dropinocean.com
 */
public interface Cursor<T> extends Closeable, Iterable<T> {

  /**
   * 判断游标接口是否被启用
   * @return true if the cursor has started to fetch items from database.
   */
  boolean isOpen();

  /**
   * 如果游标已被完全使用，并且已返回与查询匹配的所有元素，则返回true。
   * @return true if the cursor is fully consumed and has returned all elements matching the query.
   */
  boolean isConsumed();

  /**
   * 获取当前项索引。第一项的索引为0。
   * Get the current item index. The first item has the index 0.
   * 如果没有检索到第一个游标项，则返回-1。检索到的当前项的索引。
   * @return -1 if the first cursor item has not been retrieved. The index of the current item retrieved.
   */
  int getCurrentIndex();
}
