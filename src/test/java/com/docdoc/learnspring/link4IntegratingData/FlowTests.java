package com.docdoc.learnspring.link4IntegratingData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.endpoint.SourcePollingChannelAdapter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import com.docdoc.learnspring.learning.LearningApplication;
import com.rometools.rome.feed.synd.SyndEntryImpl;

@SpringBootTest(classes = LearningApplication.class)
@TestPropertySource(properties = {
    "auto.startup=false",
    "feed.file.name=Test"
})
public class FlowTests {
    @Autowired
    private SourcePollingChannelAdapter newsAdapter;
    
    @Autowired
    private MessageChannel news;

    @Test
    public void test() throws Exception {
        Assertions.assertThat(this.newsAdapter.isRunning()).isFalse();
        SyndEntryImpl syndEntry = new SyndEntryImpl();
        syndEntry.setTitle("Test Title");
        syndEntry.setLink(("http://bakabon/tensai"));
        File out = new File("/tmp/si/Test");
        out.delete();
        Assertions.assertThat(out.exists()).isFalse();
        this.news.send(MessageBuilder.withPayload(syndEntry).build());
        Assertions.assertThat(out.exists()).isTrue();
        BufferedReader br = new BufferedReader(new FileReader(out));
        String line = br.readLine();
        Assertions.assertThat(line).isEqualTo("Test Title @ http://bakabon/tensai");
        br.close();
        out.delete();
    } 
}
