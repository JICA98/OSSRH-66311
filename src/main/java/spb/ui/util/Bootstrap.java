package spb.ui.util;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Bootstrap {
//	https://cdn2.iconfinder.com/data/icons/food-drink-60/50/1F345-tomato-512.png
	
	private Bootstrap() {}
	
	public static final String CARD = "card";
	public static final String CARDB = "card-body text-center";
	public static final String META = "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">";
	public static final String BS_CSS = "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl\" crossorigin=\"anonymous\">";
	public static final String BS_JS = "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0\" crossorigin=\"anonymous\"></script>";
	
	public static final String HEAD = new StringBuilder()
			.append("<HEAD>")
			.append("<TITLE>SpringBoot</TITLE>")
			.append(META)
			.append(BS_CSS)
			.append("<link rel = \"icon\" href='https://dzone.com/storage/temp/12434118-spring-boot-logo.png' type = \"image/x-icon\"> ")
			.append("</HEAD>")
			.toString();
	
	public static final String navbar() {
		return navbar("Your Title Here", "/", "", "Home", "/", "Contact Us", "/");
	}
	
	public static final String div() {
		return div("", "", "");
	}
	
	public static final String div(String body) {
		return div("", "", body);
	}
	
	public static String div(String classes, String body) {
		return ele("DIV", classes, "", body);
	}
	
	public static String div(String classes, String attributes, String body) {
		return ele("DIV", classes, attributes, body);
	}

	
	public static String row(String attributes, String body) {
		return div("row", attributes, body);
	}
	
	public static String row( String body) {
		return div("row", "", body);
	}
	
	public static String a(String href, String classes, String attributes, String body) {
		return ele("a", classes, new StringBuilder("href='").append(href).append("' ").append(attributes).toString(), body );
	}
	
	public static String a(String href, String classes, String body) {
		return a(href, classes, "", body );
	}
	
	public static String a(String href, String body) {
		return a(href, "", body );
	}
	
	public static String textInput(String attributes) {
		return textInput("", attributes);
	}
	
	public static String textInput() {
		return textInput("");
	}
	
	public static String whitecard(String...items) {
		return div(CARD, 
				div(CARDB, 
						body(items)//domBody
						)
				);
	}
	
	public static String darkcard(String... items) {
		return div(body(CARD, " bg-dark text-white "), 
				div(CARDB, 
						body(items)//domBody
						)
				);
	}
	
	public static String greycard(String... items) {
		return div(body(CARD, " bg-secondary text-white "), 
				div(CARDB, 
						body(items)//domBody
						)
				);
	}
	
	public static String dark(String body) {
		return div(" bg-dark text-muted ", body);
	}
	
	private static final String INPUT = "input";
	private static final String FORM_CONTROL = "form-control";
	
	public static String textInput(String classes, String attributes) {
		return ele(INPUT, new StringBuilder(FORM_CONTROL).append(classes).toString()
				, new StringBuilder(" type='text' ").append(attributes).toString(), "");
	}
	
	public static String dateInput(String attributes) {
		return dateInput("", attributes);
	}
	
	public static String dateInput() {
		return dateInput("");
	}
	
	public static String dateInput(String classes, String attributes) {
		return ele(INPUT, new StringBuilder(FORM_CONTROL).append(classes).toString()
				, new StringBuilder(" type='date' ").append(attributes).toString(), "");
	}
	
	public static String numberInput(String attributes) {
		return numberInput("", attributes);
	}
	
	public static String numberInput() {
		return numberInput("");
	}
	
	public static String numberInput(String classes, String attributes) {
		return ele(INPUT, new StringBuilder(FORM_CONTROL).append(classes).toString()
				, new StringBuilder(" type='number' ").append(attributes).toString(), "");
	}
	
	public static <T> String select(String name, String classes, String attributes, Stream<T> values, Stream<T> content) {
		return ele("select", body(" form-control ", classes), 
				body(String.format(" name='%s' ", name), attributes), options(values, content) );
	}
	
	public static <T> String select(String name, String classes, String attributes, List<T> values, List<T> content) {
		return select(name, classes, attributes, values.stream(), content.stream());
	}
	
	public static <T> String select(String name, String classes, List<T> values, List<T> content) {
		return select(name, classes, "", values, content);
	}
	
	public static <T> String select(String name, String classes, Stream<T> values, Stream<T> content) {
		return select(name, classes, "", values, content);
	}
	
	public static <T> String select(String name, List<T> values, List<T> content) {
		return select(name, "", "", values, content);
	}
	
	public static <T> String select(String name, Stream<T> values, Stream<T> content) {
		return select(name, "", "", values, content);
	}
	
	public static <T> String select(String name, List<T> values) {
		return select(name, "", "", values, values);
	}
	
	public static <T> String select(String name, Stream<T> values) {
		return select(name, "", "", values, values);
	}
	
	public static <T> String select(String name, String classes, String attributes, List<T> values) {
		return select(name, classes, attributes, values, values);
	}
	
	public static <T> String select(String name, String classes, String attributes, Stream<T> values) {
		return select(name, classes, attributes, values, values);
	}
	
	public static <T> String select(String name, String classes, List<T> values) {
		return select(name, classes, "", values, values);
	}
	
	public static <T> String select(String name, String classes, Stream<T> values) {
		return select(name, classes, "", values, values);
	}
	
	
	public static <T> String options(Stream<T> values, Stream<T> content) {
		Iterator<T> contentItr = content.iterator();
		Iterator<T> valueItr = values.iterator();
		StringBuilder ctx = new StringBuilder();
		while (contentItr.hasNext() && valueItr.hasNext()) {
			Object contentObj = contentItr.next();
			Object valueObj = valueItr.next();
			ctx.append(ele("option", "", String.format("value='%s'", valueObj.toString()), contentObj.toString()));
		}
		return ctx.toString();
	}
	
	public static String container(String body) {
		return container("", "", body);
	}
	
	public static String container(String classes, String body) {
		return container(classes, "", body);
	}
	
	public static String container(String classes, String attributes, String body) {
		return div(new StringBuilder(" container ").append(classes).toString(), attributes, body);
	}
	
	public static String margin(int left, int right, int top, int bottom, String classes, String body) {
		return div(new StringBuilder(String.format(" ml-%d mr-%d mt-%d mb-%d ", left, right, top, bottom)).append(classes).toString()
				, body);
	}
	
	public static String mt(int top, String body) {
		return margin(0, 0, top, 0, "", body);
	}
	
	public static String mt(int top) {
		return margin(0, 0, top, 0, "", "");
	}
	
	public static String mb(int bottom, String body) {
		return margin(0, 0, 0, bottom,"", body);
	}
	
	public static String ml(int left, String body) {
		return margin(left, 0, 0, 0,"", body);
	}
	
	public static String mr(int right, String body) {
		return margin(0, right, 0, 0,"", body);
	}
	
	public static String my(int margin, String body) {
		return margin(0, 0, margin, margin,"", body);
	}
	
	public static String mx(int margin, String body) {
		return margin(margin, margin, 0, 0,"", body);
	}
	
	public static String padding(int left, int right, int top, int bottom, String classes, String body) {
		return div(new StringBuilder(String.format(" pl-%d pr-%d pt-%d pb-%d ", left, right, top, bottom)).append(classes).toString()
				, body);
	}
	
	public static String pt(int top, String body) {
		return padding(0, 0, top, 0, "", body);
	}
	
	public static String pt(int top) {
		return padding(0, 0, top, 0, "", "");
	}
	
	public static String pb(int bottom, String body) {
		return padding(0, 0, 0, bottom,"", body);
	}
	
	public static String pl(int left, String body) {
		return padding(left, 0, 0, 0,"", body);
	}
	
	public static String pr(int right, String body) {
		return padding(0, right, 0, 0,"", body);
	}
	
	public static String py(int margin, String body) {
		return padding(0, 0, margin, margin,"", body);
	}
	
	public static String px(int margin, String body) {
		return padding(margin, margin, 0, 0,"", body);
	}
	
	public static String button(String classes, String attributes, String body) {
		return ele("button", new StringBuilder(" btn ").append(classes).toString(), attributes, body);
	}
	
	public static String submit(String classes, String attributes, String body) {
		return button(classes, new StringBuilder(" type='submit' ").append(attributes).toString(), body);
	}
	
	public static String submit(String classes, String body) {
		return submit(classes, "", body);
	}
	
	public static String submit(String body) {
		return submit(" btn-primary ", body);
	}
	
	public static String submit() {
		return submit("Save");
	}
	
	public static String reset(String classes, String attributes, String body) {
		return button(classes, new StringBuilder(" type='reset' ").append(attributes).toString(), body);
	}
	
	public static String reset(String classes, String body) {
		return reset(classes, "", body);
	}
	
	public static String reset(String body) {
		return reset(" btn-secondary ", body);
	}
	
	public static String reset() {
		return reset("Clear");
	}
	
	public static String width(int width, String body) {
		return ele("span", "", String.format(" style='width: %dpx;' ", width), body);
	}
	
	public static String height(int height, String body) {
		return ele("span", "", String.format(" style='height: %dpx;' ", height), body);
	}
	
	
	public static String col(String attributes, String body) {
		return div("col-lg col-md col-sm col-xs", attributes, body);
	}
	
	public static String col(String body) {
		return div("col-lg col-md col-sm col-xs", "", body);
	}
	
	public static String col(int mdNum, int lgNum, int smNum, int xsNum, String attributes, String body) {
		return div(String.format("col-lg-%d col-md-%d col-sm-%d col-xs-%d", lgNum, mdNum, smNum, xsNum), attributes, body);
	}
	
	public static String col(int mdNum, int lgNum, int smNum, int xsNum, String body) {
		return div(String.format("col-lg-%d col-md-%d col-sm-%d col-xs-%d", lgNum, mdNum, smNum, xsNum), "", body);
	}
	
	public static String col(int mdNum, String attributes, String body) {
		return div(String.format("col-lg col-md-%d", mdNum), attributes, body);
	}
	
	public static String col(int mdNum, String body) {
		return div(String.format("col-lg col-md-%d", mdNum), "", body);
	}

	public static String col(int mdNum, int lgNum, String attributes, String body) {
		return div(String.format("col-lg-%d col-md-%d col-sm col-xs", lgNum, mdNum), attributes, body);
	}
	
	public static String col(int mdNum, int lgNum, String body) {
		return div(String.format("col-lg-%d col-md-%d col-sm col-xs", lgNum, mdNum), "", body);
	}
	
	public static String col(int mdNum, int lgNum,int smNum, String attributes, String body) {
		return div(String.format("col-lg-%d col-md-%d col-sm-%d col-xs", lgNum, mdNum, smNum), attributes, body);
	}
	
	public static String col(int mdNum, int lgNum,int smNum, String body) {
		return div(String.format("col-lg-%d col-md-%d col-sm-%d col-xs", lgNum, mdNum, smNum), "", body);
	}
	
	public static String colLg(int lgNum, String body) {
		return div(String.format("col-lg-%d col-md", lgNum), "", body);
	}
	
	
	public static String ele(String type, String body) {
		return ele(type, "", "", body);
	}
	
	public static String ele(String type, String classes, String attributes, String body) {
		StringBuilder ctx = new StringBuilder();
		ctx.append("<");
		ctx.append(type.toUpperCase());
		ctx.append(" class='");
		ctx.append(classes);
		ctx.append("' ");
		ctx.append(attributes);
		ctx.append(">");
		
		ctx.append(body);
		
		ctx.append("</");
		ctx.append(type.toUpperCase());
		ctx.append(">");
		return ctx.toString();
	}
	
	public static final String body(String...items) {
		StringBuilder ctx = new StringBuilder();
		for (String string : items) {
			ctx.append(string);
			ctx.append(" ");
		}
		return ctx.toString();
	}
	
	
	public static String navbar(String title, String titleLink, String classes, String...itemsAndLinks) {
		 StringBuilder ctx = new StringBuilder()
			.append("<NAV CLASS='")
			.append(body( classes, "NAVBAR NAVBAR-EXPAND-LG  NAVBAR-DARK BG-DARK"))
			.append("'>")
			.append("<DIV CLASS='CONTAINER'>")
			.append(a(titleLink, " NAVBAR-BRAND nav-link ", title));
		 
		 
			ctx.append("<button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\"\r\n" + 
					"                data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\r\n" + 
					"                aria-label=\"Toggle navigation\">\r\n" + 
					"                <span class=\"navbar-toggler-icon\"></span>\r\n" + 
					"            </button>");
			
			ctx.append("<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n" + 
					"\r\n" + 
					"                <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\"></ul>\r\n" + 
					"\r\n" + 
					"                <ul class=\"navbar-nav d-flex\">");
			for (int i=0, n=itemsAndLinks.length; i<n; i+=2 ) {
				String item = itemsAndLinks[i];
				String link = itemsAndLinks[i+1];
				ctx.append(String.format(" <li class=\"nav-item\"><a class=\"nav-link\" href='%s'>", link));
				ctx.append(item);
				ctx.append("</a></li>");
			}
			ctx.append("</ul>\r\n" + 
					"            </div>");
			
			ctx.append(" </DIV>").append("</NAV>");
		
		return ctx.toString();
	}
	
	public static final String errorAlert(String errorMessage) {
		return alert("danger", errorMessage);
	}
	
	public static final String infoAlert(String message) {
		return alert("info", message);
	}
	
	public static final String alert(String type, String message) {
		return new StringBuilder()
				.append(String.format("<DIV class='ALERT ALERT-%s alert-dismissible fade show'> <b>%s! </b>", type, type.toUpperCase()))
				.append(message)
				.append("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>")
				.append("</DIV>")
				.toString();
	}
	
	static final String html(String head, String body) {
		StringBuilder ctx = new StringBuilder();
		ctx.append("<HTML>");
		ctx.append(head);
		ctx.append("<BODY>");
		ctx.append(body);
		ctx.append(BS_JS);
		ctx.append("</BODY>");
		ctx.append("</HTML>");
		return ctx.toString();
	}
	
	public static final String html(String body) {
		return html(HEAD, body);
	}
	
	public static final String darkFooter(String content) {
		return ele("footer", "bg-DARK", "style='width: 100%; color: white; position: fixed; bottom: 0;'", content);
	}
	
	public static String footer() {
		return darkFooter(py(1, ele("center", "Copyright &copy 2021")));
	}

}
