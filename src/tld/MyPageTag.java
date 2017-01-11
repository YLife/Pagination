package tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * �Զ����ǩ�������Բ�����ǩ��
 * <my:page url="" />   
 * �������ҳ                                              
 * @author Administrator
 *
 */
public class MyPageTag extends SimpleTagSupport {
	private String url;
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 *�����������Զ����ǩ��ʱ��ͻ����tld�ļ��е����������ñ�ǩ��������doTag���� 
	 */
	@Override
	public void doTag() throws JspException, IOException {
		int sum = Integer.parseInt(this.getJspContext().findAttribute("sum")+"");
		int pageNo = Integer.parseInt(this.getJspContext().findAttribute("pageNo")+"");
		
		JspWriter out = this.getJspContext().getOut();
		//��һҳ
		out.write("<li><a href='"+url+"?pageNo="+((pageNo-1)<=1?1:(pageNo-1))+"'>&laquo;</a></li>");
		//�м�ҳ��
		for (int i = 1; i <= sum; i++) {
			out.write("<li class="+(i == pageNo ? "active" : "")+"><a href='"+url+"?pageNo="+i+"'>"+i+"</a></li>");
		}
		//��һҳ
		out.write("<li><a href='"+url+"?pageNo="+((pageNo + 1) >= sum ? sum : (pageNo + 1))+"'>&raquo;</a></li>");
	}
}
