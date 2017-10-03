package org.alf;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class CollectionTest {

	@Test
	public void testListExpectIsSubsetOfActualWithOrder() {
		List<String> actual = Arrays.asList(new String[] {"item1", "item2", "item3"});
		assertThat("List Expect Is Subset Of Actual With Order", actual, containsInRelativeOrder("item1", "item2"));
	}

	@Ignore
	@Test
	public void testListExpectIsSubsetOfActualWithoutOrder() {
		// No idea yet
//		List<String> actual = Arrays.asList(new String[] {"item1", "item2", "item3"});
//		assertThat("List Expect Is Subset Of Actual With Order", actual, ?("item2", "item1"));
	}

	@Test
	public void testListActualIsSubsetOfExpectWithoutOrder() {
		List<String> actual = Arrays.asList(new String[] {"item1", "item2"});
		assertThat("List Actual Is Subset Of Expect Without Order", actual, everyItem(is(in(new String[] {"item3", "item2", "item1"}))));
	}

	@Ignore
	@Test
	public void testListActualIsSubsetOfExpectWithOrder() {
		// No idea yet
//		List<String> actual = Arrays.asList(new String[] {"item1", "item2"});
//		assertThat("List Actual Is Subset Of Expect Without Order", actual, ?("item1", "item2", "item3"));
	}

	@Test
	public void testListActualIsEqualOfExpectWithoutOrder() {
		List<String> actual = Arrays.asList(new String[] {"item1", "item2", "item3"});
		assertThat("List Actual Is Subset Of Expect Without Order", actual, containsInAnyOrder("item3", "item2", "item1"));
	}

	@Test
	public void testListActualIsEqualOfExpectWithOrder() {
		List<String> actual = Arrays.asList(new String[] {"item1", "item2", "item3"});
		assertThat("List Actual Is Subset Of Expect Without Order", actual, contains("item1", "item2", "item3"));
	}

	
//	@Test
//	public void testCheckActualMapIsSubsetOfExpectMapWithoutOrder() {
//	}
//
//	@Test
//	public void testCheckActualMapIsSubsetOfExpectMapWithOrder() {
//	}
//
//	@Test
//	public void testCheckActualMapIsEqualOfExpectMapWithOrder() {
//	}
//
//	@Test
//	public void testCheckActualMapIsEqualOfExpectMapWithoutOrder() {
//	}
//

//	@Test
//	public void testCheckActualSetIsSubsetOfExpectSetWithoutOrder() {
//	}
//
//	@Test
//	public void testCheckActualSetIsSubsetOfExpectSetWithOrder() {
//	}
//
//	@Test
//	public void testCheckActualSetIsEqualOfExpectSetWithOrder() {
//	}
//
//	@Test
//	public void testCheckActualSetIsEqualOfExpectSetWithoutOrder() {
//	}
}
