package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 제약이 많고 복잡하다, 실무에서는 검증 기능이 해당 객체의 범위를 넘어서는 경우가 있기 때문에 대응이 어렵다.
@ScriptAssert(
        lang = "javascript",
        script = "_this.price * _this.quantity >= 10000",
        message = "총합이 10,000원이 넘어야 합니다."
)
 **/
@Data
public class Item {

    @NotNull // 수정 요구사항(수정할 떄 Id값 필수)
    private Long id;

    @NotBlank(message = "공백을 입력할 수 없습니다.")
    private String itemName;

    @NotNull
    @Range(min = 1000, max = 100000)
    private Integer price;

    @NotNull
    //@Max(9999) // 수정 요구사항(수정 시 수량 무제한)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
