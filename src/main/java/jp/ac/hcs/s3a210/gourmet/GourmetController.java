package jp.ac.hcs.s3a210.gourmet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GourmetController {
	
	@Autowired
	private GourmetService gourmetService;
	
	/**
	 * キーワードを検索し、該当する店舗を表示する
	 * @param shopname 検索するキーワード
	 * @param principal ログイン情報
	 * @param model
	 * @return 結果画面-郵便番号
	 */
	@GetMapping("/gourmet")
	public String getGourmet(@RequestParam("shopname")String shopname, Model model) {
				
				String API_KEY = "4178dbdbdde5c690"; 
				String large_service_area = "SS40";
				ShopEntity shopEntity = gourmetService.getShops(API_KEY,shopname,large_service_area);
				model.addAttribute("shopEntity", shopEntity);
				return "gourmet/gourmet";
		
	}

}
