package jica.spb.bootstrap.util;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Jica
 *
 */
public class Bootstrap {
	
	/**
	 * 
	 */
	private Bootstrap() {}
	
	/**
	 * 
	 */
	protected static final String CARD = "card";
	/**
	 * 
	 */
	protected static final String CARDB = "card-body text-center";
	
	
	/**
	 * Meta content is
	 * name='viewport' content='width=device-width initial-scale=1'
	 */
	public static final String META = "<meta name='viewport' content='width=device-width, initial-scale=1'>";
	/**
	 * Bootstrap v5.0 CSS link
	 * https://getbootstrap.com/docs/5.0/getting-started/introduction/
	 */
	public static final String BS_CSS = "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl\" crossorigin=\"anonymous\">";
	/**
	 * Bootstrap v5.0 JS Bundled link
	 * https://getbootstrap.com/docs/5.0/getting-started/introduction/
	 */
	public static final String BS_JS = "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0\" crossorigin=\"anonymous\"></script>";
	
	
	/**
	 * @param content	takes additional content to be attached to the head element
	 * 
	 * it adds the meta content and css link by default
	 * @return [head]...[/head]
	 */
	public static final String head(String meta, String css, String iconLink, String title, String content) {
		return new StringBuilder()
				.append("<HEAD>")
				.append("<TITLE>%s</TITLE>")
				.append(META)
				.append(BS_CSS)
				.append("<link rel = \"icon\" href='' type = \"image/x-icon\"> ")
				.append(content)
				.append("</HEAD>")
				.toString();
	}
	
	/**
	 * @param content
	 * @return
	 */
	public static final String head(String content) {
		return head(META, BS_CSS, "https://dzone.com/storage/temp/12434118-spring-boot-logo.png", "SpringBoot", content );
	}
	
	/**
	 * @return
	 */
	public static final String head() {
		return head("");
	}
	
	/**
	 * @return
	 */
	public static final String div() {
		return div("", "", "");
	}
	
	/**
	 * @param body
	 * @return
	 */
	public static final String div(String body) {
		return div("", "", body);
	}
	
	/**
	 * @param classes
	 * @param body
	 * @return
	 */
	public static String div(String classes, String body) {
		return ele("DIV", classes, "", body);
	}
	
	/**
	 * @param classes
	 * @param attributes
	 * @param body
	 * @return
	 */
	public static String div(String classes, String attributes, String body) {
		return ele("DIV", classes, attributes, body);
	}

	
	/**
	 * @param attributes
	 * @param body
	 * @return
	 */
	public static String row(String attributes, String body) {
		return div("row", attributes, body);
	}
	
	/**
	 * @param body
	 * @return
	 */
	public static String row( String body) {
		return div("row", "", body);
	}
	
	/**
	 * @param href
	 * @param classes
	 * @param attributes
	 * @param body
	 * @return
	 */
	public static String a(String href, String classes, String attributes, String body) {
		return ele("a", classes, new StringBuilder("href='").append(href).append("' ").append(attributes).toString(), body );
	}
	
	/**
	 * @param href
	 * @param classes
	 * @param body
	 * @return
	 */
	public static String a(String href, String classes, String body) {
		return a(href, classes, "", body );
	}
	
	/**
	 * @param href
	 * @param body
	 * @return
	 */
	public static String a(String href, String body) {
		return a(href, "", body );
	}
	
	/**
	 * @param attributes
	 * @return
	 */
	public static String textInput(String attributes) {
		return textInput("", attributes);
	}
	
	/**
	 * @return
	 */
	public static String textInput() {
		return textInput("");
	}
	
	/**
	 * @param items
	 * @return
	 */
	public static String whitecard(String...items) {
		return div(CARD, 
				div(CARDB, 
						body(items)//domBody
						)
				);
	}
	
	/**
	 * @param items
	 * @return
	 */
	public static String darkcard(String... items) {
		return div(body(CARD, " bg-dark text-white "), 
				div(CARDB, 
						body(items)//domBody
						)
				);
	}
	
	/**
	 * @param items
	 * @return
	 */
	public static String greycard(String... items) {
		return div(body(CARD, " bg-secondary text-white "), 
				div(CARDB, 
						body(items)//domBody
						)
				);
	}
	
	/**
	 * @param body
	 * @return
	 */
	public static String dark(String body) {
		return div(" bg-dark text-muted ", body);
	}
	
	/**
	 * 
	 */
	private static final String INPUT = "input";
	/**
	 * 
	 */
	private static final String FORM_CONTROL = "form-control";
	
	/**
	 * @param classes
	 * @param attributes
	 * @return
	 */
	public static String textInput(String classes, String attributes) {
		return ele(INPUT, new StringBuilder(FORM_CONTROL).append(classes).toString()
				, new StringBuilder(" type='text' ").append(attributes).toString(), "");
	}
	
	/**
	 * @param attributes
	 * @return
	 */
	public static String dateInput(String attributes) {
		return dateInput("", attributes);
	}
	
	/**
	 * @return
	 */
	public static String dateInput() {
		return dateInput("");
	}
	
	/**
	 * @param classes
	 * @param attributes
	 * @return
	 */
	public static String dateInput(String classes, String attributes) {
		return ele(INPUT, new StringBuilder(FORM_CONTROL).append(classes).toString()
				, new StringBuilder(" type='date' ").append(attributes).toString(), "");
	}
	
	/**
	 * @param attributes
	 * @return
	 */
	public static String numberInput(String attributes) {
		return numberInput("", attributes);
	}
	
	/**
	 * @return
	 */
	public static String numberInput() {
		return numberInput("");
	}
	
	/**
	 * @param classes
	 * @param attributes
	 * @return
	 */
	public static String numberInput(String classes, String attributes) {
		return ele(INPUT, new StringBuilder(FORM_CONTROL).append(classes).toString()
				, new StringBuilder(" type='number' ").append(attributes).toString(), "");
	}
	
	/**
	 * @param <T>
	 * @param name
	 * @param classes
	 * @param attributes
	 * @param values
	 * @param content
	 * @return
	 */
	public static <T> String select(String name, String classes, String attributes, Stream<T> values, Stream<T> content) {
		return ele("select", body(" form-control ", classes), 
				body(String.format(" name='%s' ", name), attributes), options(values, content) );
	}
	
	/**
	 * @param <T>
	 * @param name
	 * @param classes
	 * @param attributes
	 * @param values
	 * @param content
	 * @return
	 */
	public static <T> String select(String name, String classes, String attributes, List<T> values, List<T> content) {
		return select(name, classes, attributes, values.stream(), content.stream());
	}
	
	/**
	 * @param <T>
	 * @param name
	 * @param classes
	 * @param values
	 * @param content
	 * @return
	 */
	public static <T> String select(String name, String classes, List<T> values, List<T> content) {
		return select(name, classes, "", values, content);
	}
	
	/**
	 * @param <T>
	 * @param name
	 * @param classes
	 * @param values
	 * @param content
	 * @return
	 */
	public static <T> String select(String name, String classes, Stream<T> values, Stream<T> content) {
		return select(name, classes, "", values, content);
	}
	
	/**
	 * @param <T>
	 * @param name
	 * @param values
	 * @param content
	 * @return
	 */
	public static <T> String select(String name, List<T> values, List<T> content) {
		return select(name, "", "", values, content);
	}
	
	/**
	 * @param <T>
	 * @param name
	 * @param values
	 * @param content
	 * @return
	 */
	public static <T> String select(String name, Stream<T> values, Stream<T> content) {
		return select(name, "", "", values, content);
	}
	
	/**
	 * @param <T>
	 * @param name
	 * @param values
	 * @return
	 */
	public static <T> String select(String name, List<T> values) {
		return select(name, "", "", values, values);
	}
	
	/**
	 * @param <T>
	 * @param name
	 * @param values
	 * @return
	 */
	public static <T> String select(String name, Stream<T> values) {
		return select(name, "", "", values, values);
	}
	
	/**
	 * @param <T>
	 * @param name
	 * @param classes
	 * @param attributes
	 * @param values
	 * @return
	 */
	public static <T> String select(String name, String classes, String attributes, List<T> values) {
		return select(name, classes, attributes, values, values);
	}
	
	/**
	 * @param <T>
	 * @param name
	 * @param classes
	 * @param attributes
	 * @param values
	 * @return
	 */
	public static <T> String select(String name, String classes, String attributes, Stream<T> values) {
		return select(name, classes, attributes, values, values);
	}
	
	/**
	 * @param <T>
	 * @param name
	 * @param classes
	 * @param values
	 * @return
	 */
	public static <T> String select(String name, String classes, List<T> values) {
		return select(name, classes, "", values, values);
	}
	
	/**
	 * @param <T>
	 * @param name
	 * @param classes
	 * @param values
	 * @return
	 */
	public static <T> String select(String name, String classes, Stream<T> values) {
		return select(name, classes, "", values, values);
	}
	
	
	/**
	 * @param <T>
	 * @param values
	 * @param content
	 * @return
	 */
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
	
	/**
	 * @param body
	 * @return
	 */
	public static String container(String body) {
		return container("", "", body);
	}
	
	/**
	 * @param classes
	 * @param body
	 * @return
	 */
	public static String container(String classes, String body) {
		return container(classes, "", body);
	}
	
	/**
	 * @param classes
	 * @param attributes
	 * @param body
	 * @return
	 */
	public static String container(String classes, String attributes, String body) {
		return div(new StringBuilder(" container ").append(classes).toString(), attributes, body);
	}
	
	/**
	 * @param left
	 * @param right
	 * @param top
	 * @param bottom
	 * @param classes
	 * @param body
	 * @return
	 */
	public static String margin(int left, int right, int top, int bottom, String classes, String body) {
		return div(new StringBuilder(String.format(" ml-%d mr-%d mt-%d mb-%d ", left, right, top, bottom)).append(classes).toString()
				, body);
	}
	
	/**
	 * @param top
	 * @param body
	 * @return
	 */
	public static String mt(int top, String body) {
		return margin(0, 0, top, 0, "", body);
	}
	
	/**
	 * @param top
	 * @return
	 */
	public static String mt(int top) {
		return margin(0, 0, top, 0, "", "");
	}
	
	/**
	 * @param bottom
	 * @param body
	 * @return
	 */
	public static String mb(int bottom, String body) {
		return margin(0, 0, 0, bottom,"", body);
	}
	
	/**
	 * @param left
	 * @param body
	 * @return
	 */
	public static String ml(int left, String body) {
		return margin(left, 0, 0, 0,"", body);
	}
	
	/**
	 * @param right
	 * @param body
	 * @return
	 */
	public static String mr(int right, String body) {
		return margin(0, right, 0, 0,"", body);
	}
	
	/**
	 * @param margin
	 * @param body
	 * @return
	 */
	public static String my(int margin, String body) {
		return margin(0, 0, margin, margin,"", body);
	}
	
	/**
	 * @param margin
	 * @param body
	 * @return
	 */
	public static String mx(int margin, String body) {
		return margin(margin, margin, 0, 0,"", body);
	}
	
	/**
	 * @param left
	 * @param right
	 * @param top
	 * @param bottom
	 * @param classes
	 * @param body
	 * @return
	 */
	public static String padding(int left, int right, int top, int bottom, String classes, String body) {
		return div(new StringBuilder(String.format(" pl-%d pr-%d pt-%d pb-%d ", left, right, top, bottom)).append(classes).toString()
				, body);
	}
	
	/**
	 * @param top
	 * @param body
	 * @return
	 */
	public static String pt(int top, String body) {
		return padding(0, 0, top, 0, "", body);
	}
	
	/**
	 * @param top
	 * @return
	 */
	public static String pt(int top) {
		return padding(0, 0, top, 0, "", "");
	}
	
	/**
	 * @param bottom
	 * @param body
	 * @return
	 */
	public static String pb(int bottom, String body) {
		return padding(0, 0, 0, bottom,"", body);
	}
	
	/**
	 * @param left
	 * @param body
	 * @return
	 */
	public static String pl(int left, String body) {
		return padding(left, 0, 0, 0,"", body);
	}
	
	/**
	 * @param right
	 * @param body
	 * @return
	 */
	public static String pr(int right, String body) {
		return padding(0, right, 0, 0,"", body);
	}
	
	/**
	 * @param margin
	 * @param body
	 * @return
	 */
	public static String py(int margin, String body) {
		return padding(0, 0, margin, margin,"", body);
	}
	
	/**
	 * @param margin
	 * @param body
	 * @return
	 */
	public static String px(int margin, String body) {
		return padding(margin, margin, 0, 0,"", body);
	}
	
	/**
	 * @param classes
	 * @param attributes
	 * @param body
	 * @return
	 */
	public static String button(String classes, String attributes, String body) {
		return ele("button", new StringBuilder(" btn ").append(classes).toString(), attributes, body);
	}
	
	/**
	 * @param classes
	 * @param attributes
	 * @param body
	 * @return
	 */
	public static String submit(String classes, String attributes, String body) {
		return button(classes, new StringBuilder(" type='submit' ").append(attributes).toString(), body);
	}
	
	/**
	 * @param classes
	 * @param body
	 * @return
	 */
	public static String submit(String classes, String body) {
		return submit(classes, "", body);
	}
	
	/**
	 * @param body
	 * @return
	 */
	public static String submit(String body) {
		return submit(" btn-primary ", body);
	}
	
	/**
	 * @return
	 */
	public static String submit() {
		return submit("Save");
	}
	
	/**
	 * @param classes
	 * @param attributes
	 * @param body
	 * @return
	 */
	public static String reset(String classes, String attributes, String body) {
		return button(classes, new StringBuilder(" type='reset' ").append(attributes).toString(), body);
	}
	
	/**
	 * @param classes
	 * @param body
	 * @return
	 */
	public static String reset(String classes, String body) {
		return reset(classes, "", body);
	}
	
	/**
	 * @param body
	 * @return
	 */
	public static String reset(String body) {
		return reset(" btn-secondary ", body);
	}
	
	/**
	 * @return
	 */
	public static String reset() {
		return reset("Clear");
	}
	
	/**
	 * @param width
	 * @param body
	 * @return
	 */
	public static String width(int width, String body) {
		return ele("span", "", String.format(" style='width: %dpx;' ", width), body);
	}
	
	/**
	 * @param height
	 * @param body
	 * @return
	 */
	public static String height(int height, String body) {
		return ele("span", "", String.format(" style='height: %dpx;' ", height), body);
	}
	
	
	/**
	 * @param attributes
	 * @param body
	 * @return
	 */
	public static String col(String attributes, String body) {
		return div("col-lg col-md col-sm col-xs", attributes, body);
	}
	
	/**
	 * @param body
	 * @return
	 */
	public static String col(String body) {
		return div("col-lg col-md col-sm col-xs", "", body);
	}
	
	/**
	 * @param mdNum
	 * @param lgNum
	 * @param smNum
	 * @param xsNum
	 * @param attributes
	 * @param body
	 * @return
	 */
	public static String col(int mdNum, int lgNum, int smNum, int xsNum, String attributes, String body) {
		return div(String.format("col-lg-%d col-md-%d col-sm-%d col-xs-%d", lgNum, mdNum, smNum, xsNum), attributes, body);
	}
	
	/**
	 * @param mdNum
	 * @param lgNum
	 * @param smNum
	 * @param xsNum
	 * @param body
	 * @return
	 */
	public static String col(int mdNum, int lgNum, int smNum, int xsNum, String body) {
		return div(String.format("col-lg-%d col-md-%d col-sm-%d col-xs-%d", lgNum, mdNum, smNum, xsNum), "", body);
	}
	
	/**
	 * @param mdNum
	 * @param attributes
	 * @param body
	 * @return
	 */
	public static String col(int mdNum, String attributes, String body) {
		return div(String.format("col-lg col-md-%d", mdNum), attributes, body);
	}
	
	/**
	 * @param mdNum
	 * @param body
	 * @return
	 */
	public static String col(int mdNum, String body) {
		return div(String.format("col-lg col-md-%d", mdNum), "", body);
	}

	/**
	 * @param mdNum
	 * @param lgNum
	 * @param attributes
	 * @param body
	 * @return
	 */
	public static String col(int mdNum, int lgNum, String attributes, String body) {
		return div(String.format("col-lg-%d col-md-%d col-sm col-xs", lgNum, mdNum), attributes, body);
	}
	
	/**
	 * @param mdNum
	 * @param lgNum
	 * @param body
	 * @return
	 */
	public static String col(int mdNum, int lgNum, String body) {
		return div(String.format("col-lg-%d col-md-%d col-sm col-xs", lgNum, mdNum), "", body);
	}
	
	/**
	 * @param mdNum
	 * @param lgNum
	 * @param smNum
	 * @param attributes
	 * @param body
	 * @return
	 */
	public static String col(int mdNum, int lgNum,int smNum, String attributes, String body) {
		return div(String.format("col-lg-%d col-md-%d col-sm-%d col-xs", lgNum, mdNum, smNum), attributes, body);
	}
	
	/**
	 * @param mdNum
	 * @param lgNum
	 * @param smNum
	 * @param body
	 * @return
	 */
	public static String col(int mdNum, int lgNum,int smNum, String body) {
		return div(String.format("col-lg-%d col-md-%d col-sm-%d col-xs", lgNum, mdNum, smNum), "", body);
	}
	
	/**
	 * @param lgNum
	 * @param body
	 * @return
	 */
	public static String colLg(int lgNum, String body) {
		return div(String.format("col-lg-%d col-md", lgNum), "", body);
	}
	
	
	/**
	 * @param type
	 * @param body
	 * @return
	 */
	public static String ele(String type, String body) {
		return ele(type, "", "", body);
	}
	
	/**
	 * @param type
	 * @param classes
	 * @param attributes
	 * @param body
	 * @return
	 */
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
	
	/**
	 * @param items
	 * @return
	 */
	public static final String body(String...items) {
		StringBuilder ctx = new StringBuilder();
		for (String string : items) {
			ctx.append(string);
			ctx.append(" ");
		}
		return ctx.toString();
	}
	
	/**
	 * @param title			the title to be added inside navbar-brand
	 * @param titleLink 	the link to jump when the navbar brand is clicked
	 * @param classes		use body() to add multiple classes to the navbar or
	 * a single class like "text-white"
	 * @param itemsAndLinks		content followed by the link it should jump to
	 * eg:<blockquote>
	 * 		- "Home", "/home", "Contact Us", "/contact-us"
	 * </blockquote>
	 * @return String. bootstrap-navbar bg-dark.
	 * It sets the navbar items as
	 * <blockquote>
	 *  - "Your Title Here" 
	 *  - "Home"
	 *  - "Contact Us"  
	 *  -
	 * </blockquote>
	 */
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
	
	
	/**
	 * 
	 * @return String. bootstrap-navbar bg-dark.
	 * It sets the navbar items as
	 * <blockquote>
	 *  - "Your Title Here" 
	 *  - "Home"
	 *  - "Contact Us"  
	 *  -
	 * </blockquote>
	 */
	public static final String navbar() {
		return navbar("Your Title Here", "/", "", "Home", "/", "Contact Us", "/");
	}
	
	/**
	 * @param errorMessage
	 * @return
	 */
	public static final String errorAlert(String errorMessage) {
		return alert("danger", errorMessage);
	}
	
	/**
	 * @param message
	 * @return
	 */
	public static final String infoAlert(String message) {
		return alert("info", message);
	}
	
	/**
	 * @param type
	 * @param message
	 * @return
	 */
	public static final String alert(String type, String message) {
		return new StringBuilder()
				.append(String.format("<DIV class='ALERT ALERT-%s alert-dismissible fade show'> <b>%s! </b>", type, type.toUpperCase()))
				.append(message)
				.append("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>")
				.append("</DIV>")
				.toString();
	}
	
	/**
	 * @param head
	 * @param body
	 * @return
	 */
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
	
	/**
	 * @param body
	 * @return
	 */
	public static final String html(String body) {
		return html(head(), body);
	}
	
	/**
	 * @param content
	 * @return
	 */
	public static final String darkFooter(String content) {
		return ele("footer", "bg-DARK", "style='width: 100%; color: white; position: fixed; bottom: 0;'", content);
	}
	
	/**
	 * @return
	 */
	public static String footer() {
		return darkFooter(py(1, ele("center", "Copyright &copy 2021")));
	}

}
