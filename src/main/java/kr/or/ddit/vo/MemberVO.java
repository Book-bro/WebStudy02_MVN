package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * VO(Value Object), DTO(Data Transfer Object), JavaBean, Model
 * 
 * JavaBean 규약
 * 1. 값을 담을 수 있는 property 정의
 * 2. property 캡슐화
 * 3. 캡슐화된 프로퍼티에 접근할 수 있는 인터페이스 제공 getter/setter
 *       get[set] + 프로퍼티명의 첫분자를 대문자로 -> camel case
 * 4. 객체의 상태 비교 방법 제공 : equals
 *       ==, equals
 * 5. 객체의 상태 확인 방법 제공 : toString
 * 6. 객체 직렬화 가능
 * 
 * 회원관리를 위한 Domain Layer
 * 	: 한사람의 회원 정보(구매기록 포함)를 담기 위한 객체
 * 	  MEMBER(1) : PROD(N) -> HAS MANY
 * 	  1 : 1 -> HAS A
 */
//@Getter
//@Setter
@ToString(exclude = {"memPass", "memRegno1", "memRegno2"})
@EqualsAndHashCode(of="memId")
@Data
@NoArgsConstructor
public class MemberVO implements Serializable {
	
	
	public MemberVO(@NotBlank(groups = { Default.class, DeleteGroup.class }) String memId,
			@NotBlank(groups = { Default.class, DeleteGroup.class }) @Size(min = 4, max = 8, groups = { Default.class,
					DeleteGroup.class }) String memPass) {
		super();
		this.memId = memId;
		this.memPass = memPass;
	}
	@NotBlank(groups= {Default.class, DeleteGroup.class})
	private String memId;
	@NotBlank(groups= {Default.class, DeleteGroup.class})
	@Size(min=4,max=8,groups= {Default.class, DeleteGroup.class})
	@JsonIgnore
	private transient String memPass;
	@NotBlank
	private String    memName;
	@JsonIgnore
	private transient String memRegno1;
	@JsonIgnore
	private transient String memRegno2;
	@Pattern(regexp="\\d{4}-\\d{2}-\\d{2}",groups=InsertGroup.class)
	@NotBlank(groups=InsertGroup.class)
	private String memBir;
	@NotBlank
	private String memZip;
	@NotBlank
	private String memAdd1;
	@NotBlank
	private String memAdd2;
	private String memHometel;
	private String memComtel;
	private String memHp;
	@Email
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	@Pattern(regexp="\\d{4}-\\d{2}-\\d{2}")
	private String memMemorialday;
	@Min(0)
	private Integer memMileage;
	private boolean memDelete;
    
	private int cartCount;
	
	private List<ProdVO> prodList; //has many 관계(1:N)
	
   
   
}