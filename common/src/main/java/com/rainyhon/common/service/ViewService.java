package com.rainyhon.common.service;

import com.microcore.center.mapper.ViewMapper;
import com.microcore.center.model.Column;
import com.microcore.center.model.DynamicQueryVo;
import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.Unary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ViewService {

	public static final String GT = "gt";

	public static final String LT = "lt";

	public static final String EQ = "eq";

	public static final String BETWEEN = "between";

	public static final String START = "*";

	public static final String LTEQ = "lteq";

	public static final String NEQ = "neq";

	public static final String GTEQ = "gteq";

	public static final String IN = "in";

	public static final String AND = "and";

	public static final String MARKS = "'";
	public static final String LIKE = "like";

	@Autowired
	private ViewMapper viewMapper;

	public ResultVo getColumnByViewName(String name) {
		List<Column> list = viewMapper.getColumnByViewName(name);
		ResultVo vo = new ResultVo();
		vo.setData(list);
		return vo;
	}

	public ResultVo getAllViewName() {
		List<String> list = viewMapper.getAllViewName();
		ResultVo vo = new ResultVo();
		vo.setData(list);
		return vo;
	}

	private final String SELECT = "select";

	private final String FROM = "from";

	private final String WHERE = "where";

	private final String SPACE = " ";

	private final String COMMA = ",";

	private final String PRE_BRACKET = "(";

	private final String SUF_BRACKET = ")";

	private final String DEFAULT_CONDITION = "1=1";

	public ResultVo query(DynamicQueryVo query) {
		ResultVo vo = new ResultVo();
		StringBuilder sql = new StringBuilder();
		// select
		sql.append(SELECT);
		sql.append(SPACE);
		List<Column> columns = query.getColumns();
		if (columns == null || columns.isEmpty()) {
			sql.append(START);
		} else {
			columns.forEach(column -> {
				sql.append(column.getName());
				sql.append(COMMA);
			});
			sql.deleteCharAt(sql.length() - 1);
		}
		// from
		sql.append(SPACE).append(FROM).append(SPACE);
		sql.append(query.getView());
		// where
		sql.append(SPACE).append(WHERE).append(SPACE);
		sql.append(DEFAULT_CONDITION).append(SPACE).append(AND).append(SPACE);
		// condition;
		appendConditions(sql, query.getUnary());
		System.out.println(sql.toString());
		//		vo.setData(list);
		List<Map<String, String>> result = viewMapper.query(sql.toString());
		vo.setData(result);
		return vo;
	}

	/**
	 * 追加条件
	 *
	 * @param sql
	 * @param unary
	 */
	private void appendConditions(StringBuilder sql, Unary unary) {
		if (unary != null) {
			// a = 1
			switch (unary.getCondition()) {
				case GT:
					sql.append(unary.getColumn()).append(">").append(formatValue(unary.getValue(), unary.getType()));
					break;
				case GTEQ:
					sql.append(unary.getColumn()).append(">=").append(formatValue(unary.getValue(), unary.getType()));
					break;
				case LT:
					sql.append(unary.getColumn()).append("<").append(formatValue(unary.getValue(), unary.getType()));
					break;
				case LTEQ:
					sql.append(unary.getColumn()).append("<=").append(formatValue(unary.getValue(), unary.getType()));
					break;
				case EQ:
					sql.append(unary.getColumn()).append("=").append(formatValue(unary.getValue(), unary.getType()));
					break;
				case NEQ:
					sql.append(unary.getColumn()).append("!=").append(formatValue(unary.getValue(), unary.getType()));
					break;
				case BETWEEN:
					String[] betweenValue = unary.getValue().split(COMMA);
					if (betweenValue.length != 0) {
						throw new IllegalArgumentException("between条件参数不足或大于2个");
					}
					sql.append(unary.getValue())
							.append(SPACE).append("between").append(SPACE)
							.append(formatValue(betweenValue[0], unary.getType())).append("and").append(SPACE).append(formatValue(betweenValue[1], unary.getType()));
					break;
				case IN:
					String[] inValue = unary.getValue().split(COMMA);
					sql.append(unary.getColumn()).append(SPACE).append("in").append(SPACE);
					// (
					sql.append(PRE_BRACKET);
					for(String value : inValue){
						sql.append(formatValue(value, unary.getType())).append(COMMA);
					}
					sql.deleteCharAt(sql.length() - 1);
					// )
					sql.append(SUF_BRACKET);
					break;
				case LIKE:
					break;
			}
		}
		Unary aftUnary = unary.getAftUnary();
		Unary childUnary = unary.getChildUnary();
		if (aftUnary != null && childUnary != null) {
			throw new IllegalArgumentException(unary.getColumn() + "的aftUnary,childUnary属性不可同时存在");
		}
		if (aftUnary != null) {
			// and || or
			sql.append(SPACE).append(aftUnary.getRelation()).append(SPACE);
			appendConditions(sql, aftUnary);
		}
		if (childUnary != null) {
			// and || or
			sql.append(SPACE).append(childUnary.getRelation()).append(SPACE);
			// 一对括号为一元
			// (
			sql.append(PRE_BRACKET);
			appendConditions(sql, childUnary);
			// )
			sql.append(SUF_BRACKET);
		}

	}

	private String formatValue(String value, String type) {
		String result = null;
		switch (type.toLowerCase()) {
			case "varchar":
				result = MARKS + value + MARKS;
				break;
			case "integer":
				result = value;
				break;
		}
		return result;
	}

	public Map<String, String> getAllCondtion() {
		Map<String, String> condition = new HashMap<>();
		condition.put(GT, "大于");
		condition.put(LT, "小于");
		condition.put(EQ, "等于");
		condition.put(NEQ, "不等于");
		condition.put(LTEQ, "小于等于");
		condition.put(GTEQ, "大于等于");
		condition.put(BETWEEN, "之间");
		condition.put(IN, "包含");
		condition.put(LIKE, "模糊");
		return condition;
	}
}
