package de.schauderhaft.meta

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers._
import de.schauderhaft.degraph.check.Check._

@RunWith(classOf[JUnitRunner])
class DependencyTest extends FunSuite {

    test("dependency test") {
        classpath //
            .including("de.schauderhaft.**") //
            .withSlicing("part", "de.schauderhaft.(*).**").allow("degraph", "meta")
            .withSlicing("module", "de.schauderhaft.*.(*).**")
            .withSlicing("layer", "de.schauderhaft.*.*.(*).**") should be(violationFree)
    }
}