package hello.itemservice.domain.item;

import hello.itemservice.web.validation.form.ItemSaveForm;
import hello.itemservice.web.validation.form.ItemUpdateForm;
import lombok.Data;

@Data
public class Item {

    private Long id;

    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void toSaveForm(ItemSaveForm form){
        itemName = form.getItemName();;
        price = form.getPrice();
        quantity = form.getQuantity();
    }

    public void toUpdateForm(ItemUpdateForm form){
        itemName = form.getItemName();;
        price = form.getPrice();
        quantity = form.getQuantity();
    }
}
