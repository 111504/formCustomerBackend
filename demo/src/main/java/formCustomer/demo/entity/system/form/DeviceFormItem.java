package formCustomer.demo.entity.system.form;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="device_form_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceFormItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemId;

    @ManyToOne
    @JoinColumn(name = "form_id", nullable = false,foreignKey = @ForeignKey(name= "device_form_deviceform_form_id_fk"))
    private DeviceForm form;  // 關聯到主表單


    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_qty")
    private Integer itemQty;

    @Column(name = "item_price")
    private Double itemPrice;

    @Column(name = "item_amount")
    private Double itemAmount;

    public DeviceFormItem(DeviceForm form, String itemCode, String itemName, Integer itemQty, Double itemPrice, Double itemAmount) {
        this.form = form;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
        this.itemAmount = itemAmount;
    }
}
