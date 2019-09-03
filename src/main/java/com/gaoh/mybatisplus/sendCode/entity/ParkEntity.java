package com.zccs.assets_management.sendCode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 * @author gaoh
 * @version 1.0
 * @date 2019/9/3 20:32
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParkEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer parkId;//停车场Id
    private String parkName;//停车场名稱
    private Integer totalSpaceNum;//总车位数
    /*
    * "limitL": 0,
		"limitW": 0,
		"limitH": 0,
		"addr": "XXXX路XX号",
		"tel": "123456789",
		"imgUrl": "http://xxx/xxx.jpg",
		"workTime": "24小时",
		"payRule": "20分钟内免费,......"
    * */

}
