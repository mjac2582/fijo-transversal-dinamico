package test.node;

class MyAdvancedLinkedListTest {
	  public static void main(String args[]) {

	    System.out.println("> Create an empty list");
	    MyAdvancedLinkedList list = new MyAdvancedLinkedList();
	    System.out.println("isEmpty() = " + list.isEmpty());
	    list.print();

	    System.out.println("> Insert C at 2");
	    list.insert((Object)"C", 2);
	    System.out.println("isEmpty() = " + list.isEmpty());
	    list.print();

	    System.out.println("> Insert D at 2");
	    list.insert((Object)"D", 2);
	    list.print();

	    System.out.println("> Insert G at 2");
	    list.insert((Object)"G", 2);
	    list.print();

	    System.out.println("> Insert F at 2");
	    list.insert((Object)"F", 2);
	    list.print();

	    System.out.println("> Insert E at 2");
	    list.insert((Object)"E", 2);
	    list.print();

	    System.out.println("> Insert A at 0");
	    list.insert((Object)"A", 0);
	    list.print();

	    System.out.println("> Insert B at 1");
	    list.insert((Object)"B", 1);
	    list.print();

	    System.out.println("> Insert <<<-- at 0");
	    list.insert((Object)"<<<--", 0);
	    list.print();

	    System.out.println("> Insert -->>> at 100");
	    list.insert((Object)"-->>>", 100);
	    list.print();

	    System.out.println("> Extract at -1: " + (String) list.extract(-1));
	    list.print();

	    System.out.println("> Extract at -1: " + (String) list.extract(-1));
	    list.print();

	    System.out.println("> Extract at 0: " + (String) list.extract(0));
	    list.print();

	    System.out.println("> Extract at 1: " + (String) list.extract(1));
	    list.print();

	    System.out.println("> Extract at 2: " + (String) list.extract(2));
	    list.print();

	    System.out.println("> Extract at 3: " + (String) list.extract(3));
	    list.print();

	    System.out.println("> Extract at 100: " + (String) list.extract(100));
	    list.print();

	    System.out.println("> Insert -->>> at 100");
	    list.insert((Object)"-->>>", 2);
	    list.print();

	    System.out.println("> Extract at 2: " + (String) list.extract(100));
	    list.print();

	    System.out.println("> Insert __bla__ at 1");
	    list.insert((Object)"__bla__", 1);
	    list.print();

	    System.out.println("> Extract at 0: " + (String) list.extract(0));
	    list.print();

	    System.out.println("> Extract at 1: " + (String) list.extract(1));
	    list.print();

	    System.out.println("isEmpty() = " + list.isEmpty());

	    System.out.println("> Extract at 1: " + (String) list.extract(1));
	    list.print();
	    System.out.println("isEmpty() = " + list.isEmpty());

	    System.out.println("> Insert __bla__ at 1");
	    list.insert((Object)"__bla__", 1);
	    list.print();

	    System.out.println("> Extract at -1: " + (String) list.extract(-1));
	    list.print();
	    System.out.println("isEmpty() = " + list.isEmpty());

	    System.out.println("> Insert __bla__ at 1");
	    list.insert((Object)"__bla__", 1);
	    list.print();

	    System.out.println("> Extract at 0: " + (String) list.extract(0));
	    list.print();
	    System.out.println("isEmpty() = " + list.isEmpty());
	  }
	}