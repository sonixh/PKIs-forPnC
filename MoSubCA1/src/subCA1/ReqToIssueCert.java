package subCA1;
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ReqToIssueCert.proto

public final class ReqToIssueCert {
  private ReqToIssueCert() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ReqToIssueCertFormatOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ReqToIssueCertFormat)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required bytes subjectCsrFile = 1;</code>
     */
    boolean hasSubjectCsrFile();
    /**
     * <code>required bytes subjectCsrFile = 1;</code>
     */
    com.google.protobuf.ByteString getSubjectCsrFile();

    /**
     * <code>required string subjectCertName = 2;</code>
     */
    boolean hasSubjectCertName();
    /**
     * <code>required string subjectCertName = 2;</code>
     */
    java.lang.String getSubjectCertName();
    /**
     * <code>required string subjectCertName = 2;</code>
     */
    com.google.protobuf.ByteString
        getSubjectCertNameBytes();
  }
  /**
   * Protobuf type {@code ReqToIssueCertFormat}
   */
  public  static final class ReqToIssueCertFormat extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ReqToIssueCertFormat)
      ReqToIssueCertFormatOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ReqToIssueCertFormat.newBuilder() to construct.
    private ReqToIssueCertFormat(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ReqToIssueCertFormat() {
      subjectCsrFile_ = com.google.protobuf.ByteString.EMPTY;
      subjectCertName_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ReqToIssueCertFormat(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              subjectCsrFile_ = input.readBytes();
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              subjectCertName_ = bs;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ReqToIssueCert.internal_static_ReqToIssueCertFormat_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ReqToIssueCert.internal_static_ReqToIssueCertFormat_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ReqToIssueCert.ReqToIssueCertFormat.class, ReqToIssueCert.ReqToIssueCertFormat.Builder.class);
    }

    private int bitField0_;
    public static final int SUBJECTCSRFILE_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString subjectCsrFile_;
    /**
     * <code>required bytes subjectCsrFile = 1;</code>
     */
    public boolean hasSubjectCsrFile() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required bytes subjectCsrFile = 1;</code>
     */
    public com.google.protobuf.ByteString getSubjectCsrFile() {
      return subjectCsrFile_;
    }

    public static final int SUBJECTCERTNAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object subjectCertName_;
    /**
     * <code>required string subjectCertName = 2;</code>
     */
    public boolean hasSubjectCertName() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string subjectCertName = 2;</code>
     */
    public java.lang.String getSubjectCertName() {
      java.lang.Object ref = subjectCertName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          subjectCertName_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string subjectCertName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSubjectCertNameBytes() {
      java.lang.Object ref = subjectCertName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        subjectCertName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasSubjectCsrFile()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasSubjectCertName()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, subjectCsrFile_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, subjectCertName_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, subjectCsrFile_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, subjectCertName_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof ReqToIssueCert.ReqToIssueCertFormat)) {
        return super.equals(obj);
      }
      ReqToIssueCert.ReqToIssueCertFormat other = (ReqToIssueCert.ReqToIssueCertFormat) obj;

      boolean result = true;
      result = result && (hasSubjectCsrFile() == other.hasSubjectCsrFile());
      if (hasSubjectCsrFile()) {
        result = result && getSubjectCsrFile()
            .equals(other.getSubjectCsrFile());
      }
      result = result && (hasSubjectCertName() == other.hasSubjectCertName());
      if (hasSubjectCertName()) {
        result = result && getSubjectCertName()
            .equals(other.getSubjectCertName());
      }
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasSubjectCsrFile()) {
        hash = (37 * hash) + SUBJECTCSRFILE_FIELD_NUMBER;
        hash = (53 * hash) + getSubjectCsrFile().hashCode();
      }
      if (hasSubjectCertName()) {
        hash = (37 * hash) + SUBJECTCERTNAME_FIELD_NUMBER;
        hash = (53 * hash) + getSubjectCertName().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ReqToIssueCert.ReqToIssueCertFormat parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ReqToIssueCert.ReqToIssueCertFormat parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ReqToIssueCert.ReqToIssueCertFormat parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ReqToIssueCert.ReqToIssueCertFormat parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ReqToIssueCert.ReqToIssueCertFormat parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ReqToIssueCert.ReqToIssueCertFormat parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ReqToIssueCert.ReqToIssueCertFormat parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ReqToIssueCert.ReqToIssueCertFormat parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ReqToIssueCert.ReqToIssueCertFormat parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ReqToIssueCert.ReqToIssueCertFormat parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ReqToIssueCert.ReqToIssueCertFormat parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ReqToIssueCert.ReqToIssueCertFormat parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(ReqToIssueCert.ReqToIssueCertFormat prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code ReqToIssueCertFormat}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ReqToIssueCertFormat)
        ReqToIssueCert.ReqToIssueCertFormatOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ReqToIssueCert.internal_static_ReqToIssueCertFormat_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ReqToIssueCert.internal_static_ReqToIssueCertFormat_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ReqToIssueCert.ReqToIssueCertFormat.class, ReqToIssueCert.ReqToIssueCertFormat.Builder.class);
      }

      // Construct using ReqToIssueCert.ReqToIssueCertFormat.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        subjectCsrFile_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        subjectCertName_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ReqToIssueCert.internal_static_ReqToIssueCertFormat_descriptor;
      }

      public ReqToIssueCert.ReqToIssueCertFormat getDefaultInstanceForType() {
        return ReqToIssueCert.ReqToIssueCertFormat.getDefaultInstance();
      }

      public ReqToIssueCert.ReqToIssueCertFormat build() {
        ReqToIssueCert.ReqToIssueCertFormat result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public ReqToIssueCert.ReqToIssueCertFormat buildPartial() {
        ReqToIssueCert.ReqToIssueCertFormat result = new ReqToIssueCert.ReqToIssueCertFormat(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.subjectCsrFile_ = subjectCsrFile_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.subjectCertName_ = subjectCertName_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof ReqToIssueCert.ReqToIssueCertFormat) {
          return mergeFrom((ReqToIssueCert.ReqToIssueCertFormat)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ReqToIssueCert.ReqToIssueCertFormat other) {
        if (other == ReqToIssueCert.ReqToIssueCertFormat.getDefaultInstance()) return this;
        if (other.hasSubjectCsrFile()) {
          setSubjectCsrFile(other.getSubjectCsrFile());
        }
        if (other.hasSubjectCertName()) {
          bitField0_ |= 0x00000002;
          subjectCertName_ = other.subjectCertName_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasSubjectCsrFile()) {
          return false;
        }
        if (!hasSubjectCertName()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ReqToIssueCert.ReqToIssueCertFormat parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ReqToIssueCert.ReqToIssueCertFormat) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private com.google.protobuf.ByteString subjectCsrFile_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes subjectCsrFile = 1;</code>
       */
      public boolean hasSubjectCsrFile() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required bytes subjectCsrFile = 1;</code>
       */
      public com.google.protobuf.ByteString getSubjectCsrFile() {
        return subjectCsrFile_;
      }
      /**
       * <code>required bytes subjectCsrFile = 1;</code>
       */
      public Builder setSubjectCsrFile(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        subjectCsrFile_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes subjectCsrFile = 1;</code>
       */
      public Builder clearSubjectCsrFile() {
        bitField0_ = (bitField0_ & ~0x00000001);
        subjectCsrFile_ = getDefaultInstance().getSubjectCsrFile();
        onChanged();
        return this;
      }

      private java.lang.Object subjectCertName_ = "";
      /**
       * <code>required string subjectCertName = 2;</code>
       */
      public boolean hasSubjectCertName() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string subjectCertName = 2;</code>
       */
      public java.lang.String getSubjectCertName() {
        java.lang.Object ref = subjectCertName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            subjectCertName_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string subjectCertName = 2;</code>
       */
      public com.google.protobuf.ByteString
          getSubjectCertNameBytes() {
        java.lang.Object ref = subjectCertName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          subjectCertName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string subjectCertName = 2;</code>
       */
      public Builder setSubjectCertName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        subjectCertName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string subjectCertName = 2;</code>
       */
      public Builder clearSubjectCertName() {
        bitField0_ = (bitField0_ & ~0x00000002);
        subjectCertName_ = getDefaultInstance().getSubjectCertName();
        onChanged();
        return this;
      }
      /**
       * <code>required string subjectCertName = 2;</code>
       */
      public Builder setSubjectCertNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        subjectCertName_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:ReqToIssueCertFormat)
    }

    // @@protoc_insertion_point(class_scope:ReqToIssueCertFormat)
    private static final ReqToIssueCert.ReqToIssueCertFormat DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ReqToIssueCert.ReqToIssueCertFormat();
    }

    public static ReqToIssueCert.ReqToIssueCertFormat getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<ReqToIssueCertFormat>
        PARSER = new com.google.protobuf.AbstractParser<ReqToIssueCertFormat>() {
      public ReqToIssueCertFormat parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new ReqToIssueCertFormat(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ReqToIssueCertFormat> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ReqToIssueCertFormat> getParserForType() {
      return PARSER;
    }

    public ReqToIssueCert.ReqToIssueCertFormat getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ReqToIssueCertFormat_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ReqToIssueCertFormat_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024ReqToIssueCert.proto\"G\n\024ReqToIssueCert" +
      "Format\022\026\n\016subjectCsrFile\030\001 \002(\014\022\027\n\017subjec" +
      "tCertName\030\002 \002(\tB\020B\016ReqToIssueCert"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_ReqToIssueCertFormat_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ReqToIssueCertFormat_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ReqToIssueCertFormat_descriptor,
        new java.lang.String[] { "SubjectCsrFile", "SubjectCertName", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
