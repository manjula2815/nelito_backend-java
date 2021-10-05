package com.nelito.signup.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseObject {

	private String respmsg;
	private String respstatus;
	private String respcode;
	private List<Login> resultset = new ArrayList<Login>();

	public List<Login> getResultset() {
		return resultset;
	}

	public void setResultset(List<Login> viewlist) {
		this.resultset = viewlist;
	}

	public String getRespmsg() {
		return respmsg;
	}

	public void setRespmsg(String respmsg) {
		this.respmsg = respmsg;
	}

	public String getRespstatus() {
		return respstatus;
	}

	public void setRespstatus(String respstatus) {
		this.respstatus = respstatus;
	}

	public String getRespcode() {
		return respcode;
	}

	public void setRespcode(String respcode) {
		this.respcode = respcode;
	}

	public ResponseObject() {
		super();
	}

	public ResponseObject(String respmsg, String respstatus, String respcode, List<Login> resultset) {
		super();
		this.respmsg = respmsg;
		this.respstatus = respstatus;
		this.respcode = respcode;
		this.resultset = resultset;
	}

}
