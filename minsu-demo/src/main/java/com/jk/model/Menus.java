package com.jk.model;

import java.util.List;

public class Menus {
    private Integer id;

    private String text;

    private Integer pid;

    private String href;
    
    private List<Menus> nodes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public List<Menus> getNodes() {
		return nodes;
	}

	public void setNodes(List<Menus> nodes) {
		this.nodes = nodes;
	}

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Menus [id=" + id + ", text=" + text + ", pid=" + pid + ", href=" + href + ", nodes=" + nodes + "]";
	}

  
}