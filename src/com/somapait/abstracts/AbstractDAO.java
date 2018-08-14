package com.somapait.abstracts;

import java.sql.Connection;
import java.util.List;

/**
 * @param <C>
 *            Criteria
 * @param <R>
 *            Search Result
 * @param <T>
 *            Main domain
 * @param <U>
 *            Common User
 * @param <L>
 *            Locale
 */
public abstract class AbstractDAO<C, R, T, U, L> {

	/**
	 * @Desc For Count Search Button
	 * @param conn
	 * @param criteria
	 * @param confirm
	 *            (confirm status for user confirm to show result over max
	 *            limit)
	 * @return
	 * @throws Exception
	 */
	protected abstract int countData(Connection conn, C criteria, U user, L locale) throws Exception;

	/**
	 * @Desc For Search Button
	 * @param conn
	 * @param criteria
	 * @param confirm
	 *            (confirm status for user confirm to show result over max
	 *            limit)
	 * @return
	 * @throws Exception
	 */
	protected abstract List<R> search(Connection conn, C criteria, U user, L locale) throws Exception;

	/**
	 * @Desc For Load Edit or View Button
	 * @param conn
	 * @param id
	 * @return
	 * @throws Exception
	 */
	protected abstract T searchById(Connection conn, String id, U user, L locale) throws Exception;

	/**
	 * @Desc For Add Button
	 * @param conn
	 * @param obj
	 * @param userId
	 * @throws Exception
	 */
	protected abstract int add(Connection conn, T obj, U user, L locale) throws Exception;

	/**
	 * @Desc For Edit Button
	 * @param conn
	 * @param obj
	 * @param userId
	 * @throws Exception
	 */
	protected abstract int edit(Connection conn, T obj, U user, L locale) throws Exception;

	/**
	 * @Desc For Delete Button
	 * @param conn
	 * @param ids
	 *            = 1,2,3,...,N กรณีต้องการลบหลายรายการ ,ids = 1 กรณีต้องการลบ 1
	 *            รายการ
	 * @param userId
	 *            for updateUser field
	 * @throws Exception
	 */
	protected abstract int delete(Connection conn, String ids, U user, L locale) throws Exception;

	/**
	 * @Desc For Active and Inactive Button
	 * @param conn
	 * @param ids
	 *            = 1,2,3,...,N กรณีต้องการ update หลายรายการ ,ids = 1 รายการ
	 * @param activeFlag
	 *            Y=active,N=inactive
	 * @param userId
	 *            for updateUser field
	 * @throws Exception
	 */
	protected abstract int updateActive(Connection conn, String ids, String activeFlag, U user, L locale) throws Exception;

	/**
	 * Check duplicate before add or edit
	 *
	 * @param conn
	 * @param obj
	 * @throws DuplicateDataException
	 */
	protected abstract boolean checkDup(Connection conn, T obj, U user, L locale) throws Exception;

}
