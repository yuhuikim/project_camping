package utils;
import logic.Member;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
public class UserEntryValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}
	public void validate(Object command, Errors errors) {
		Member member = (Member) command;
		if (!StringUtils.hasLength(member.getmId())) {
			errors.rejectValue("userId", "error.required");
		}
		if (!StringUtils.hasLength(member.getPassword())) {
			errors.rejectValue("password", "error.required");
		}
		if (!StringUtils.hasLength(member.getmName())) {
			errors.rejectValue("userName", "error.required");
		}
		if (!StringUtils.hasText(member.getPostcode())) {
			errors.rejectValue("postCode", "error.required");
		}
		if (!StringUtils.hasText(member.getAddress())) {
			errors.rejectValue("address", "error.required");
		}
		if (!StringUtils.hasText(member.getEmail())) {
			errors.rejectValue("email", "error.required");
		}
		if (errors.hasErrors()) {
			errors.reject("error.input.user");
		}
	}
}