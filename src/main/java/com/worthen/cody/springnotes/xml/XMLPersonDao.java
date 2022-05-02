package com.worthen.cody.springnotes.xml;

public class XMLPersonDao {

	private XmlJdbcConnection xMLJdbcConnection;

	public XMLPersonDao() {

	}

	public XMLPersonDao(XmlJdbcConnection xMLJdbcConnection) {
		this.xMLJdbcConnection = xMLJdbcConnection;
	}

	public XmlJdbcConnection getXMLJdbcConnection() {
		return xMLJdbcConnection;
	}

	public void setXmlJdbcConnection(XmlJdbcConnection xMLJdbcConnection) {
		this.xMLJdbcConnection = xMLJdbcConnection;
	}

}
