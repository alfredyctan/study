package org.alf;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import org.junit.Ignore;
import org.junit.Test;

public class MethodReferenceTest {

	static interface Worker {
		public int process(int a, int b);
	};
	
	static class Machine {
		
		private int a;
		
		private int b;
		
		public Machine(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int work(Worker worker) {
			return worker.process(a, b);
		}
	}

	@Test
	public void test() {
		System.out.println(new Machine(1, 2).work(Math::max));
	}

}
