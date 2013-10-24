package com.benjiaren.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "jsList")
public class JiongShiList {
	private List<JiongShi> jsList;

	public List<JiongShi> getJsList() {
		return jsList;
	}

	public void setJsList(List<JiongShi> jsList) {
		this.jsList = jsList;
	}
	
}
