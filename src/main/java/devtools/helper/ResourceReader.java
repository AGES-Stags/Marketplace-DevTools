package devtools.helper;

import java.io.InputStreamReader;
import java.security.CodeSource;
import java.io.BufferedReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.io.IOException;
import java.io.InputStream;

import devtools.Library;
import devtools.helper.adaptor.IterableEnumeration;

public class ResourceReader {

    private final StringBuilder stringBuilder;

    public ResourceReader(String resource) throws IOException {
        ZipFile zip = readZipFile();
        InputStream stream = findFileEntryStreamInput(zip, resource);
        stringBuilder = readInputStreamString(stream);
    }

    public StringBuilder getBuilder() {
        return new StringBuilder(stringBuilder);
    }

    private static ZipFile readZipFile() throws IOException {
        ZipFile zip;
        try {
            CodeSource src = ResourceReader.class.getProtectionDomain().getCodeSource();
            zip = new ZipFile(
                    src.getLocation()
                            .toString()
                            .replace("file:", ""));
        } catch (IOException e) {
            Exception cause = new RuntimeException("Failed to read class protection domain code source");
            throw new IOException("Class protection domain get source code is null", cause);
        }
        return zip;
    }

    private static InputStream findFileEntryStreamInput(ZipFile zip, String resource) throws IOException {
        IterableEnumeration<? extends ZipEntry> entries = IterableEnumeration.makeIterable(zip.entries());

        for (ZipEntry entry : entries)
            if (entry.getName().endsWith(resource))
                return zip.getInputStream(entry);

        return null;
    }

    private static StringBuilder readInputStreamString(InputStream stream) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(stream, Library.ENCODING))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
