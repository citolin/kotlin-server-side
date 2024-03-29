// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: accounts.proto

package br.com.ume.grpc.proto.accounts;

/**
 * Protobuf type {@code accounts.GetAccountByDocumentRequest}
 */
public final class GetAccountByDocumentRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:accounts.GetAccountByDocumentRequest)
    GetAccountByDocumentRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetAccountByDocumentRequest.newBuilder() to construct.
  private GetAccountByDocumentRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetAccountByDocumentRequest() {
    document_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetAccountByDocumentRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetAccountByDocumentRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            document_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
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
    return br.com.ume.grpc.proto.accounts.AccountsProto.internal_static_accounts_GetAccountByDocumentRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return br.com.ume.grpc.proto.accounts.AccountsProto.internal_static_accounts_GetAccountByDocumentRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest.class, br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest.Builder.class);
  }

  public static final int DOCUMENT_FIELD_NUMBER = 1;
  private volatile java.lang.Object document_;
  /**
   * <code>string document = 1;</code>
   * @return The document.
   */
  @java.lang.Override
  public java.lang.String getDocument() {
    java.lang.Object ref = document_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      document_ = s;
      return s;
    }
  }
  /**
   * <code>string document = 1;</code>
   * @return The bytes for document.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDocumentBytes() {
    java.lang.Object ref = document_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      document_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(document_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, document_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(document_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, document_);
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
    if (!(obj instanceof br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest)) {
      return super.equals(obj);
    }
    br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest other = (br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest) obj;

    if (!getDocument()
        .equals(other.getDocument())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + DOCUMENT_FIELD_NUMBER;
    hash = (53 * hash) + getDocument().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
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
   * Protobuf type {@code accounts.GetAccountByDocumentRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:accounts.GetAccountByDocumentRequest)
      br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return br.com.ume.grpc.proto.accounts.AccountsProto.internal_static_accounts_GetAccountByDocumentRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return br.com.ume.grpc.proto.accounts.AccountsProto.internal_static_accounts_GetAccountByDocumentRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest.class, br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest.Builder.class);
    }

    // Construct using br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest.newBuilder()
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
    @java.lang.Override
    public Builder clear() {
      super.clear();
      document_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return br.com.ume.grpc.proto.accounts.AccountsProto.internal_static_accounts_GetAccountByDocumentRequest_descriptor;
    }

    @java.lang.Override
    public br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest getDefaultInstanceForType() {
      return br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest.getDefaultInstance();
    }

    @java.lang.Override
    public br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest build() {
      br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest buildPartial() {
      br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest result = new br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest(this);
      result.document_ = document_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest) {
        return mergeFrom((br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest other) {
      if (other == br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest.getDefaultInstance()) return this;
      if (!other.getDocument().isEmpty()) {
        document_ = other.document_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object document_ = "";
    /**
     * <code>string document = 1;</code>
     * @return The document.
     */
    public java.lang.String getDocument() {
      java.lang.Object ref = document_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        document_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string document = 1;</code>
     * @return The bytes for document.
     */
    public com.google.protobuf.ByteString
        getDocumentBytes() {
      java.lang.Object ref = document_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        document_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string document = 1;</code>
     * @param value The document to set.
     * @return This builder for chaining.
     */
    public Builder setDocument(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      document_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string document = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearDocument() {
      
      document_ = getDefaultInstance().getDocument();
      onChanged();
      return this;
    }
    /**
     * <code>string document = 1;</code>
     * @param value The bytes for document to set.
     * @return This builder for chaining.
     */
    public Builder setDocumentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      document_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:accounts.GetAccountByDocumentRequest)
  }

  // @@protoc_insertion_point(class_scope:accounts.GetAccountByDocumentRequest)
  private static final br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest();
  }

  public static br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetAccountByDocumentRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetAccountByDocumentRequest>() {
    @java.lang.Override
    public GetAccountByDocumentRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetAccountByDocumentRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetAccountByDocumentRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetAccountByDocumentRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

