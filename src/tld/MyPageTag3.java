package tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 自定义标签，带属性不带标签体
 * <my:page2 url="" />   
 * 跳区域分页                                              
 * @author Administrator
 *
 */
public class MyPageTag3 extends SimpleTagSupport {
	private String url;
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 *容器解析到自定义标签的时候就会根据tld文件中的描述，调用标签处理程序的doTag方法 
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
		int leftDigit = firstDigit > 1 ? firstDigit - 1 : 1;
		int rightDigit = lastDigit < sum ? lastDigit + 1 : sum; 
		//上一页
		out.write("<li><a href='"+url+"?pageNo="+leftDigit+"'>&laquo;</a></li>");
		//中间页码
		for (int i = firstDigit ; i <= lastDigit ; i++) {
			out.write("<li class="+(i == pageNo ? "active" : "")+"><a href='"+url+"?pageNo="+i+"'>"+i+"</a></li>");
		}
		//下一页
		out.write("<li><a href='"+url+"?pageNo="+rightDigit+"'>&raquo;</a></li>");
	}
}
	
