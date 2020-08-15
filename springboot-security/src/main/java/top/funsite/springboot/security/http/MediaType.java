package top.funsite.springboot.security.http;

/**
 * 表示MIME类型，通常为设置ContentType的值
 *
 * @author Li Yuqing
 * @date 2020-07-30 15:34:39
 */
public enum MediaType {

    /**
     * json
     */
    APPLICATION_JSON_VALUE("application/json"),

    /**
     * octet-stream
     */
    APPLICATION_OCTET_STREAM_VALUE("application/octet-stream"),

    /**
     * pdf
     */
    APPLICATION_PDF_VALUE("application/pdf"),

    /**
     *
     */
    APPLICATION_STREAM_JSON_VALUE("application/stream+json"),

    /**
     *
     */
    APPLICATION_XML_VALUE("application/xml"),

    /**
     * gif
     */
    IMAGE_GIF_VALUE("image/gif"),

    /**
     * jpeg
     */
    IMAGE_JPEG_VALUE("image/jpeg"),

    /**
     * png
     */
    IMAGE_PNG_VALUE("image/png"),

    /**
     *
     */
    MULTIPART_FORM_DATA_VALUE("multipart/form-data"),

    /**
     * html
     */
    TEXT_HTML_VALUE("text/html"),

    /**
     * markdown
     */
    TEXT_MARKDOWN_VALUE("text/markdown"),

    /**
     *
     */
    TEXT_PLAIN_VALUE("text/plain"),

    /**
     *
     */
    TEXT_XML_VALUE("text/xml"),

    /**
     * word doc
     */
    APPLICATION_DOC_VALUE("application/msword"),

    /**
     * word docx
     */
    APPLICATION_DOCX_VALUE("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),

    /**
     * excel xls
     */
    APPLICATION_XLS_VALUE("application/vnd.ms-excel"),

    /**
     * excel xlsx
     */
    APPLICATION_XLSX_VALUE("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),

    /**
     * ppt
     */
    APPLICATION_PPT_VALUE("application/vnd.ms-powerpoint"),

    /**
     * pptx
     */
    APPLICATION_PPTX_VALUE("application/vnd.openxmlformats-officedocument.presentationml.presentation");

    public final String value;

    MediaType(String value) {
        this.value = value;
    }
}
