package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import cs414.a1.buehlerj.*;;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CompanyTest.class,
	ProjectTest.class,
	QualificationTest.class,
	WorkerTest.class,
})

public class TestAll {}