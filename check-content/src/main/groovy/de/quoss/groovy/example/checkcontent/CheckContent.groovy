package de.quoss.groovy.example.checkcontent

class CheckContent {

    private void run(String... args) {
        def exampleType
        if (!args) {
            throw new CheckContentException(usage());
        } else {
            exampleType = args[0]
        }
        switch (exampleType) {
            case 'checkList' :
                runCheckList();
                break;
            default :
               throw new CheckContentException(usage());
               break;
        }
    }

    private void runCheckList() {
        println "Running checkList(['eins zwei drei'], ['eins'] ..."
        println "... ${checkList(['eins zwei drei'], ['eins'])}."
        println "Running checkList(['eins zwei drei'], ['eins', 'vier'] ..."
        println "... ${checkList(['eins zwei drei'], ['eins', 'vier'])}."
        println "Running checkList(['eins zwei drei', 'vier'], ['eins', 'vier'] ..."
        println "... ${checkList(['eins zwei drei', 'vier'], ['eins', 'vier'])}."
        println "Running checkList(['eins zwei drei', 'vier'], ['vier', 'eins'] ..."
        println "... ${checkList(['eins zwei drei', 'vier'], ['vier', 'eins'])}."
    }

    private boolean checkList(def haystack, def needles) {
        def matched = [:]
        for (def needle : needles) {
            matched.(needle) = false
        }
        for (def line : haystack) {
            for (def needle : needles) {
                if (line.contains(needle)) {
                    matched.(needle) = true
                }
            }
            // check if we already matched all
            def allMatched = true
            for (def needle : needles) {
                if (matched.(needle) == false) {
                    allMatched = false
                }
            }
            if (allMatched) {
                return true
            }
        }
        return false
    }

    private String usage() {
        return "USAGE: ${getClass().name} example-type"
    }

    static void main(String... args) {
        new CheckContent().run(args)
    }

}