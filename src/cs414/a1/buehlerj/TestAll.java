package cs414.a1.buehlerj;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	CompanyTest.class,
	ProjectTest.class,
	QualificationTest.class,
	WorkerTest.class,
})

public class TestAll {}