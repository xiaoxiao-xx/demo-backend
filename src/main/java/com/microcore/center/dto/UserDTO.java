package com.microcore.center.dto;

import com.microcore.center.model.SysUser;
import com.microcore.common.constant.Constants;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * A DTO representing a user, with his authorities.
 */
@Setter
@Getter
public class UserDTO {

	private String id;

	@Pattern(regexp = Constants.LOGIN_REGEX)
	@Size(min = 1, max = 36)
	private String account;

	@Size(max = 36)
	private String username;

	@NotBlank(message = "密码不能为空")
	@Size(max = 36)
	private String password;

	@Size(max = 255)
	private String company;

	@Pattern(regexp = Constants.LOGIN_TEL, message = "请填写正确手机号")
	@Size(max = 36)
	private String tel;

	@Size(max = 64)
	private String orgId;
//    @Email
//    @Size(min = 5, max = 254)
//    private String email;
//    private boolean activated = false;
	//  private Instant createdDate;

	private Set<Integer> authorities;

	public UserDTO() {
		// Empty constructor needed for Jackson.
	}

	public UserDTO(SysUser user) {
		this.id = user.getId();
		this.account = user.getAccount();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.company = user.getCompany();
		this.tel = user.getTel();
	}

	@Override
	public String toString() {
		return "UserDTO{" +
				"id=" + id +
				", account='" + account + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", company='" + company + '\'' +
				", tel='" + tel + '\'' +
				", authorities=" + authorities +
				'}';
	}

}
