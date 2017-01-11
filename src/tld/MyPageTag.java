package tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 自定义标签，带属性不带标签体
 * <my:page url="" />   
 * 单区域分页                                              
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
	 *容器解析到自定义标签的时候就会根据tld文件中的描述，调用标签处理程序的doTag方法 
	 */
	@Override
	public void doTag() throws JspException, IOException {
		int sum = Integer.parseInt(this.getJspContext().findAttribute("sum")+"");
		int pageNo = Integer.parseInt(this.getJspContext().findAttribute("pageNo")+"");
		
		JspWriter out = this.getJspContext().getOut();
		//上一页
		out.write("<li><a href='"+url+"?pageNo="+((pageNo-1)<=1?1:(pageNo-1))+"'>&laquo;</a></li>");
		//中间页码
		for (int i = 1; i <= sum; i++) {
			out.write("<li class="+(i == pageNo ? "active" : "")+"><a href='"+url+"?pageNo="+i+"'>"+i+"</a></li>");
		}
		//下一页
		out.write("<li><a href='"+url+"?pageNo="+((pageNo + 1) >= sum ? sum : (pageNo + 1))+"'>&raquo;</a></li>");
	}
}
