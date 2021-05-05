package org.opensearch.index.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.opensearch.index.analysis.NamedAnalyzer;
import org.opensearch.test.OpenSearchTestCase;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

public class VietnameseAnalysisTokenTest extends OpenSearchTestCase {
    public void testVietnameseTokenizer() throws IOException {
        inputToken("nguyễn văn bé nhỏ", new String[] {"nguyễn", "văn", "bé nhỏ"});
    }

    public void testVietnameseTokenizerSpace() throws IOException {
        inputToken("nguyễn  văn  bé  nhỏ", new String[] {"nguyễn", "văn", "bé nhỏ"});
    }

    public void testVietnameseTokenizerSpace3() throws IOException {
        inputToken("nguyễn   văn   bé   nhỏ  ", new String[] {"nguyễn", "văn", "bé nhỏ"});
    }

    public void testVietnameseTokenizerSpace4() throws IOException {
        inputToken("nguyễn   văn   bé   bé  ", new String[] {"nguyễn", "văn", "bé bé"});
    }

    public void testVietnameseTokenizerNewline() throws IOException {
        inputToken("#Mama & #I. 😘\n\n#HoChiMinh, #Vietnam.", new String[] {"mama", "i", "😘", "hochiminh", "vietnam"});
    }

    private void inputToken(String inputText, String[] expectArray) throws IOException {
        TestAnalysis analysis = VietnameseAnalysisTest.createTestAnalysis();
        NamedAnalyzer analyzer = analysis.indexAnalyzers.get("vi_analyzer");
        assertNotNull(analyzer);

        TokenStream ts = analyzer.analyzer().tokenStream("test", inputText);
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
        ts.reset();
        for (String expected : expectArray) {
            assertThat(ts.incrementToken(), equalTo(true));
            assertThat(term.toString(), equalTo(expected));
        }
        assertThat(ts.incrementToken(), equalTo(false));
    }
}
