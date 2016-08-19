package wbs.nested_classes;

@SuppressWarnings("unused")
public class NestetTested {
	static int staticInstanceInt = 1;

	public class MemberClass {
		int memberInt = 2;

		void memberM() {
			System.out.println(staticInstanceInt);
		}
	}

	public static void main(String[] args) {
		final int inMain = 3;
		class LocalClassInStatic {
			void localStaticM() {
				int normal = 4;
				System.out.println(staticInstanceInt);
				System.out.println(inMain);
				System.out.println(normal);
			}
		}
		new LocalClassInStatic().localStaticM();
		System.out.println("******************+++++++++++++++++************");
		// wie komme ich von hier an localM() ???
	}
 
	public void murks() {
		class LocalClass {
			void localM() {
				System.out.println(staticInstanceInt);
			}
		}
	}
}