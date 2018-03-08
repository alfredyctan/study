package org.alf;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTest {

	@Test
	public void arthExpr() {
		Pattern PATTERN = Pattern.compile("\\\"([^\\\"]*)\\\"|(?:[=\\+\\*/]|^)(\\w*)");

		System.out.println("num1");
		Matcher matcher = PATTERN.matcher("num1");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
		System.out.println("=========================");

		System.out.println("num2=num3+num4-num3*num4/num3");
		matcher = PATTERN.matcher("num2=num3+num4-num3*num4/num3");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}

		System.out.println("=========================");
		System.out.println("\"num5\"");
		matcher = PATTERN.matcher("\"num5\"");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}

	}

	@Test
	public void testCaseInsensitiveWithWhitespaceAhead() {
		//regex case insensitive with whitespace ahead
		Pattern SELECT = Pattern.compile("^\\s*?(?i)select(?-i)");
		
		assertThat(SELECT.matcher(" select").find(), is(true));
		assertThat(SELECT.matcher(" SeLecT").find(), is(true));
		assertThat(SELECT.matcher(" SeLecTed").find(), is(true));
		assertThat(SELECT.matcher(" TeLecT").find(), is(false));
	}
}
