package de.schauderhaft.degraph.meta

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers._
import de.schauderhaft.degraph.check.Check._
import de.schauderhaft.degraph.check.Layer._
import de.schauderhaft.degraph.check.StrictLayer

@RunWith(classOf[JUnitRunner])
class DependencyTest extends FunSuite {

    test("dependency test") {
        classpath //
            .including("de.schauderhaft.**") //
            .withSlicing("part", "de.schauderhaft.degraph.(*).**").allow("meta", "demo")
            .withSlicing("module", "de.schauderhaft.degraph.*.(*).**").allow("order", "person")
            .withSlicing("layer", "de.schauderhaft.degraph.*.*.(*).**").allow(oneOf("persistence", "ui"), "domain") should be(violationFree)
    }
}