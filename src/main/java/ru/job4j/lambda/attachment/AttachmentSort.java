package ru.job4j.lambda.attachment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> sizeComparator = Comparator.comparingInt(Attachment::getSize);
        attachments.sort(sizeComparator);
        System.out.println(attachments);
        Comparator<Attachment> nameComparator = Comparator.comparing(Attachment::getName);
        attachments.sort(nameComparator);
        System.out.println(attachments);
    }

}
