package formCustomer.demo.dto;

import lombok.*;

import java.util.List;

@Setter
@Data
@Getter
@AllArgsConstructor
public class DeviceFormDto {
    private String applicant;//申請人
    private String purchaseDate;//請購日期
    private String purchaseNo;//請購編號
    private String purchaseDept;//請購部門
    private String companyName;//公司名稱
    private String vendorNo;//廠商編號
    private List<ItemDto> items;//設備欄
    private List<StationDto> stations;
    private String remarks;

    // Getters and Setters

    public static class ItemDto {

        private String itemCode;//設備編號
        private String itemName;//品名
        private Integer itemQty;//請購數量
        private Double itemPrice;//單價
        private Double itemAmount;//請購金額

        public String getItemCode() {
            return itemCode;
        }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public Integer getItemQty() {
            return itemQty;
        }

        public void setItemQty(Integer itemQty) {
            this.itemQty = itemQty;
        }

        public Double getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(Double itemPrice) {
            this.itemPrice = itemPrice;
        }

        public Double getItemAmount() {
            return itemAmount;
        }

        public void setItemAmount(Double itemAmount) {
            this.itemAmount = itemAmount;
        }



    }

    public static class StationDto {
        private String stationNumber;//站點
        private String position;//位階
        private String name;//姓名
        private String staffCode;//員工編號


        public String getStationNumber() {
            return stationNumber;
        }

        public void setStationNumber(String stationNumber) {
            this.stationNumber = stationNumber;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStaffCode() {
            return staffCode;
        }

        public void setStaffCode(String staffCode) {
            this.staffCode = staffCode;
        }
    }
}
