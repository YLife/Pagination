package tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * �Զ����ǩ�������Բ�����ǩ��
 * <my:page2 url="" />   
 * ������������ҳ                                              
 * @author Administrator
 *
 */
public class MyPageTag2 extends SimpleTagSupport {
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
		int pageCount = Integer.parseInt(this.getJspContext().findAttribute("pageCount")+"");
		JspWriter out = this.getJspContext().getOut();
		int part = (pageNo - 1) / pageCount + 1;
		int firstDigit = (part - 1) * pageCount +1;
		int lastDigit = part * pageCount;
		lastDigit = lastDigit > sum ? sum : lastDigit;
		//��һҳ
		out.write("<li><a href='"+url+"?pageNo="+((pageNo-1)<=1?1:(pageNo-1))+"'>&laquo;</a></li>");
		//�м�ҳ��
		for (int i = firstDigit ; i <= lastDigit ; i++) {
			out.write("<li class="+(i == pageNo ? "active" : "")+"><a href='"+url+"?pageNo="+i+"'>"+i+"</a></li>");
		}
		//��һҳ
		out.write("<li><a href='"+url+"?pageNo="+((pageNo + 1) >= sum ? sum : (pageNo + 1))+"'>&raquo;</a></li>");
	}
}
