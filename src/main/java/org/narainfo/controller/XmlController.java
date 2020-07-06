package org.narainfo.controller;

import org.narainfo.WebSpeller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XmlController {
	
	//xml 원문 데이터를 출력
	@RequestMapping(value = "/getXMLResult", method = RequestMethod.POST, produces = "application/xml")
	public String results(@RequestParam("text1") String value, @RequestParam(value="bWeakOpt", required=false) boolean bWeakOpt) {
		if(value.equals("")) {
			return "데이터를 입력해주세요";
		}
		

		WebSpeller webSpeller = new WebSpeller();
		String result = webSpeller.getResultXML(value, bWeakOpt);
		return result;
	}
}
