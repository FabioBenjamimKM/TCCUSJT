def format_float(text):
    clean_text = text.replace('R$', '').replace('.', '').replace(',', '.').replace('%', '').strip()
    return float(clean_text)
